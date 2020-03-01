package yb.lol.tft.ui.champions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_champion_composition.view.*
import yb.lol.tft.R
import yb.lol.tft.models.entities.Champion
import yb.lol.tft.ui.items.CarryItemsAdapter
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration

class CompositionChampionsAdapter :
    RecyclerView.Adapter<CompositionChampionsAdapter.ChampionsCompositionViewHolder>() {

    private var data: List<Champion> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChampionsCompositionViewHolder {
        return ChampionsCompositionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_champion_composition,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ChampionsCompositionViewHolder, position: Int) {
        val item = data[position]

        //Champion
        val defaultDrawable =
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_face_black_24dp)
        holder.itemView.iv_champion.setImageDrawable(item.image ?: defaultDrawable)

        //Carry Items
        val rvCarryItems = holder.itemView.rv_items
        val adapterCarryItems = CarryItemsAdapter()
        rvCarryItems.adapter = adapterCarryItems
        rvCarryItems.addItemDecoration(
            ItemOffsetDecoration(
                holder.itemView.context,
                R.dimen.margin_xxs,
                ItemOffsetDecoration.Orientation.HORIZONTAL
            )
        )
        //todo observer : carry items-> update adapter
    }

    fun update(newData: ArrayList<Champion>) {
        data = newData
        notifyDataSetChanged()
    }

    class ChampionsCompositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
