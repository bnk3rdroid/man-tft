package yb.lol.tft.ui.compositions.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_test_compositions.view.*
import yb.lol.tft.R
import yb.lol.tft.entities.Composition
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.view_models.ChampionsViewModel
import yb.lol.tft.view_models.ItemsViewModel
import yb.lol.tft.view_models.TypesViewModel

class TestCompositionsAdapter(
    private val typesViewModel: TypesViewModel,
    private val championsViewModel: ChampionsViewModel,
    private val itemsViewModel: ItemsViewModel,
    private val viewLifecycleOwner: LifecycleOwner
) :
    RecyclerView.Adapter<TestCompositionsAdapter.TestCompositionsVH>() {

    class TestCompositionsVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var data: List<Composition> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestCompositionsVH {
        return TestCompositionsVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_test_compositions,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TestCompositionsVH, position: Int) {
        val item = data[position]

        //Name
        holder.itemView.tv_name.text = item.name

        //Types
        typesViewModel.typesFromComposition(item.id)
            .observe(viewLifecycleOwner, Observer { types ->
                var typesText = "Types : "
                var i = 0
                for (type in types) {
                    ++i
                    typesText += if (i < types.size) "${type.name}, " else type.name
                }
                holder.itemView.tv_types.text = typesText
            })

        //Rank
        val rankText = "Rank : ${item.rank.name} tier"
        holder.itemView.tv_rank.text = rankText

        //Champions
        val rvChampions = holder.itemView.rv_optimal_champions
        val adapterChampions =
            TestChampionsAdapter(typesViewModel, itemsViewModel, viewLifecycleOwner)
        rvChampions.adapter = adapterChampions
        rvChampions.addItemDecoration(
            ItemOffsetDecoration(
                holder.itemView.context,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )
        championsViewModel.championsFromComposition(item.id)
            .observe(viewLifecycleOwner, Observer { champions ->
                adapterChampions.update(champions)
            })

        //Closer: Champions
        val arrowSection = holder.itemView.iv_arrow_section
        arrowSection.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context,
                if (rvChampions.isVisible) R.drawable.ic_arrow_drop_up_black_24dp
                else R.drawable.ic_arrow_drop_down_black_24dp
            )
        )
        holder.itemView.rl_section_closer.setOnClickListener {
            if (rvChampions.isVisible) {
                rvChampions.visibility = View.GONE
                arrowSection.setImageDrawable(
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.ic_arrow_drop_down_black_24dp
                    )
                )
            } else {
                rvChampions.visibility = View.VISIBLE
                arrowSection.setImageDrawable(
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.ic_arrow_drop_up_black_24dp
                    )
                )
            }
        }
    }

    fun update(newData: List<Composition>) {
        data = newData
        notifyDataSetChanged()
    }
}