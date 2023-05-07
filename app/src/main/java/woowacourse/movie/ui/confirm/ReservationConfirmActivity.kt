package woowacourse.movie.ui.confirm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import java.time.ZoneId
import woowacourse.movie.R
import woowacourse.movie.databinding.ActivityReservationConfirmBinding
import woowacourse.movie.model.MoneyState
import woowacourse.movie.model.TicketsState
import woowacourse.movie.ui.BackKeyActionBarActivity
import woowacourse.movie.ui.DateTimeFormatters
import woowacourse.movie.ui.DecimalFormatters
import woowacourse.movie.util.getParcelableExtraCompat
import woowacourse.movie.util.keyError

class ReservationConfirmActivity : BackKeyActionBarActivity(), ReservationConfirmContract.View {
    override lateinit var presenter: ReservationConfirmContract.Presenter
    override lateinit var binding: ActivityReservationConfirmBinding

    override fun onCreateView(savedInstanceState: Bundle?) {
        presenter.setUpTicket()
    }

    override fun initBinding() {
        binding = ActivityReservationConfirmBinding.inflate(layoutInflater)
    }

    override fun initPresenter() {
        presenter = ReservationConfirmPresenter(
            this,
            intent.getParcelableExtraCompat(KEY_TICKETS) ?: return keyError(KEY_TICKETS)
        )
    }

    override fun setTicket(ticket: TicketsState) {
        binding.reservationTitle.text = ticket.movieName
        binding.reservationDate.text = DateTimeFormatters.convertToDateTime(ticket.dateTime)
        binding.reservationCountAndSeat.text = binding.root.context.getString(
            R.string.person_count_and_seat,
            ticket.positions.size,
            ticket.positions.joinToString { it.toString() },
            ticket.cinemaName
        )
    }

    override fun setMoney(money: MoneyState) {
        binding.reservationMoney.text = DecimalFormatters.convertToMoneyFormat(money)
    }

    override fun registerNotification(ticket: TicketsState) {
        val alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val alarmIntent = AlarmReceiver.getIntent(this, ticket).let { intent ->
            PendingIntent.getBroadcast(
                this,
                ticket.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT + PendingIntent.FLAG_IMMUTABLE
            )
        }

        val advanceNoticeDateTime = ticket.dateTime
            .minusMinutes(ADVANCE_NOTICE_MINUTES)
            .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            advanceNoticeDateTime,
            alarmIntent
        )
    }

    companion object {
        private const val KEY_TICKETS = "key_tickets"
        private const val ADVANCE_NOTICE_MINUTES = 30L

        fun startActivity(context: Context, tickets: TicketsState) {
            val intent = Intent(context, ReservationConfirmActivity::class.java).apply {
                putExtra(KEY_TICKETS, tickets)
            }
            context.startActivity(intent)
        }
    }
}
