package my.jalal.made.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_game.view.*
import my.jalal.made.core.R
import my.jalal.made.core.domain.model.Game

class GameAdapter : RecyclerView.Adapter<GameAdapter.ListViewHolder>() {
    private var listData = ArrayList<Game>()
    var onItemCLick: ((Game) -> Unit)? = null

    fun setData(newListData: List<Game>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Game) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.backgroundImage)
                    .into(iv_game)
                tv_name.text = data.name
                tv_score.text = data.rating.toString()
            }
        }

        init {
            itemView.setOnClickListener {
                onItemCLick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_game, parent, false)
    )


    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: GameAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }
}