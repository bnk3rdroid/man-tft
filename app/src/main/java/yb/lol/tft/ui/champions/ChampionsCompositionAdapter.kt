package yb.lol.tft.ui.champions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_champion_composition.view.*
import yb.lol.tft.R
import yb.lol.tft.models.Champion
import yb.lol.tft.ui.items.CarryItemsAdapter
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration

class ChampionsCompositionAdapter :
    RecyclerView.Adapter<ChampionsCompositionAdapter.ChampionsCompositionViewHolder>() {

    private var data: ArrayList<Champion> = arrayListOf()
    private var decoratedOnce: ArrayList<Int> = arrayListOf()

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
        holder.itemView.iv_champion.setImageDrawable(item.image)
        //Carry ?: Items
        holder.itemView.rv_items.apply {
            adapter = CarryItemsAdapter()
            if (item.carryItems != null) {
                (adapter as CarryItemsAdapter).update(item.carryItems!!)
            }
        }
        //Decorations
        if (!decoratedOnce.contains(position)) {
            holder.itemView.rv_items.apply {
                addItemDecoration(
                    ItemOffsetDecoration(
                        context,
                        R.dimen.item_decoration_horizontal_margin_xsmall,
                        ItemOffsetDecoration.Orientation.HORIZONTAL
                    )
                )
            }
            decoratedOnce.add(position)
        }
    }

    fun update(newData: ArrayList<Champion>) {
        data = newData
        notifyDataSetChanged()
    }

    class ChampionsCompositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
