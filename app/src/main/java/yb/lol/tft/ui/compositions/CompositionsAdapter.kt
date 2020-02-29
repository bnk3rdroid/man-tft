package yb.lol.tft.ui.compositions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_composition.view.*
import yb.lol.tft.R
import yb.lol.tft.models.Composition
import yb.lol.tft.models.Rank
import yb.lol.tft.ui.champions.ChampionsCompositionAdapter
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.ui.types.TypesSmallAdapter

class CompositionsAdapter : RecyclerView.Adapter<CompositionsAdapter.CompositionsViewHolder>() {

    private var data: ArrayList<Composition> = arrayListOf()
    private var decoratedOnce: ArrayList<Int> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositionsViewHolder {
        return CompositionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_composition,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CompositionsViewHolder, position: Int) {
        val ctx = holder.itemView.context
        val item = data[position]

        //Name
        holder.itemView.tv_name.text = item.name
        //Rank
        holder.itemView.ranking_note.text = data[position].rank.name
        holder.itemView.bg_ranking.background = ContextCompat.getDrawable(
            ctx, when (item.rank) {
                Rank.S -> R.drawable.bg_ranking_s
                Rank.A -> R.drawable.bg_ranking_a
                Rank.B -> R.drawable.bg_ranking_b
                Rank.C -> R.drawable.bg_ranking_c
            }
        )

        //Types
        holder.itemView.rv_types.apply {
            adapter = TypesSmallAdapter()
            (adapter as TypesSmallAdapter).update(item.types)
        }

        //Champions
        holder.itemView.rv_champions.apply {
            adapter = ChampionsCompositionAdapter()
            (adapter as ChampionsCompositionAdapter).update(item.optimalChampions)
        }

        //Decorations
        if (!decoratedOnce.contains(position)) {
            holder.itemView.rv_types.apply {
                addItemDecoration(
                    ItemOffsetDecoration(
                        context,
                        R.dimen.item_decoration_horizontal_margin_small,
                        ItemOffsetDecoration.Orientation.HORIZONTAL
                    )
                )
            }
            holder.itemView.rv_champions.apply {
                addItemDecoration(
                    ItemOffsetDecoration(
                        context,
                        R.dimen.item_decoration_horizontal_margin_small,
                        ItemOffsetDecoration.Orientation.HORIZONTAL
                    )
                )
            }
            decoratedOnce.add(position)
        }
    }

    fun update(newData: ArrayList<Composition>) {
        data = newData
        notifyDataSetChanged()
    }

    class CompositionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}