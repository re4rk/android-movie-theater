package woowacourse.movie.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.movie.databinding.ItemCinemaBottomSheetBinding
import woowacourse.movie.ui.main.itemModel.ItemModel
import woowacourse.movie.ui.main.viewHolder.CinemaListViewHolder
import woowacourse.movie.ui.main.viewHolder.ItemViewHolder

class CinemaListAdapter(
    cinemas: List<ItemModel>,
    val onArrowButtonClick: (itemModel: ItemModel) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {
    private var cinemas = cinemas.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding = ItemCinemaBottomSheetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CinemaListViewHolder(itemBinding) { position ->
            onArrowButtonClick(
                cinemas[position]
            )
        }
    }

    override fun getItemCount(): Int = cinemas.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(cinemas[position])
    }
}