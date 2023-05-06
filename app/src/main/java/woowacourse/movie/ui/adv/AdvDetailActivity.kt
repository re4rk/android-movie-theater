package woowacourse.movie.ui.adv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import woowacourse.movie.databinding.ActivityAdvDetailBinding
import woowacourse.movie.model.AdvState
import woowacourse.movie.ui.BackKeyActionBarActivity
import woowacourse.movie.util.getParcelableExtraCompat
import woowacourse.movie.util.keyError

class AdvDetailActivity : BackKeyActionBarActivity(), AdvDetailContract.View {
    private lateinit var binding: ActivityAdvDetailBinding
    override fun onCreateView(savedInstanceState: Bundle?) {
        initBinding()
        initPresenter()
    }

    private fun initBinding() {
        binding = ActivityAdvDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initPresenter() {
        val presenter = AdvDetailPresenter(this)
        presenter.getAdv(intent.getParcelableExtraCompat(KEY_ADV) ?: return keyError(KEY_ADV))
    }

    override fun setAdv(advState: AdvState) {
        binding.adv = advState
    }

    companion object {
        private const val KEY_ADV = "key_adb"

        fun startActivity(context: Context, advState: AdvState) {
            val intent = Intent(context, AdvDetailActivity::class.java).apply {
                putExtra(KEY_ADV, advState)
            }
            context.startActivity(intent)
        }
    }
}
