package yb.lol.tft.ui.compositions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_composition.view.*
import yb.lol.tft.R
import yb.lol.tft.entities.Composition
import yb.lol.tft.entities.Rank
import yb.lol.tft.ui.champions.CompositionChampionsAdapter
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.ui.types.TypesSmallAdapter

class CompositionsAdapter : RecyclerView.Adapter<CompositionsAdapter.CompositionsViewHolder>() {

    private var data: List<Composition> = listOf()

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
        holder.itemView.ranking_note.text =
            if (item.rank == Rank.UNKNOWN) "?"
            else item.rank.name
        holder.itemView.bg_ranking.background = ContextCompat.getDrawable(
            ctx, when (item.rank) {
                Rank.S -> R.drawable.bg_ranking_s
                Rank.A -> R.drawable.bg_ranking_a
                Rank.B -> R.drawable.bg_ranking_b
                Rank.C -> R.drawable.bg_ranking_c
                else -> R.drawable.bg_ranking_unknown
            }
        )

        //Types
        val rvTypes = holder.itemView.rv_types
        val adapterTypes = TypesSmallAdapter()
        rvTypes.adapter = adapterTypes
        rvTypes.addItemDecoration(
            ItemOffsetDecoration(
                holder.itemView.context,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.HORIZONTAL
            )
        )
        //todo observer : types -> adapter update

        //Champions
        val rvOptimalChampions = holder.itemView.rv_champions
        val adapterOptimalChampions = CompositionChampionsAdapter()
        rvOptimalChampions.adapter = adapterOptimalChampions
        rvOptimalChampions.addItemDecoration(
            ItemOffsetDecoration(
                holder.itemView.context,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.HORIZONTAL
            )
        )
        //todo observer : optimal champions -> adapter update

    }

    fun update(newData: List<Composition>) {
        data = newData
        notifyDataSetChanged()
    }

    class CompositionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}