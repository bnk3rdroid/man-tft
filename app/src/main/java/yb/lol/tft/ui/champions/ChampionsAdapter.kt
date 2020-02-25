package yb.lol.tft.ui.champions

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_champion.view.*
import yb.lol.tft.models.Champion

class ChampionsAdapter : RecyclerView.Adapter<ChampionsAdapter.ChampionsViewHolder>() {

    private var data: ArrayList<Champion> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionsViewHolder {
        val view = ChampionView(parent.context)

        return ChampionsViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ChampionsViewHolder, position: Int) {
        holder.itemView.imageView.setImageDrawable(data[position].image)
    }

    fun update(newData: ArrayList<Champion>) {
        data = newData
        notifyDataSetChanged()
    }

    class ChampionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}