package yb.lol.tft.ui.compositions.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_test_optimal_champions.view.*
import yb.lol.tft.R
import yb.lol.tft.entities.Champion
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.view_models.ItemsViewModel
import yb.lol.tft.view_models.TypesViewModel

class TestChampionsAdapter(
    private val typesViewModel: TypesViewModel,
    private val itemsViewModel: ItemsViewModel,
    private val lifecycleOwner: LifecycleOwner
) :
    RecyclerView.Adapter<TestCompositionsAdapter.TestCompositionsVH>() {

    class TestCompositionChampionsVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var data: List<Champion> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TestCompositionsAdapter.TestCompositionsVH {
        return TestCompositionsAdapter.TestCompositionsVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_test_optimal_champions,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(
        holder: TestCompositionsAdapter.TestCompositionsVH,
        position: Int
    ) {
        val item = data[position]

        //name
        holder.itemView.tv_name.text = item.name

        //Level
        val costText = "Cost : ${item.cost} gold"
        holder.itemView.tv_cost.text = costText

        //Types
        typesViewModel.typesFromChampion(item.id).observe(lifecycleOwner, Observer { types ->
            var typesText = "Types : "
            var i = 0
            for (type in types) {
                ++i
                typesText += if (i < types.size) "${type.name}, " else type.name
            }
            holder.itemView.tv_types.text = typesText
        })

        //Mana
        val manaText = "Mana : ${item.mana}"
        holder.itemView.tv_mana.text = manaText

        //Health
        val healthText =
            "Health : ${item.health_lvl_one} / ${item.health_lvl_two} / ${item.health_lvl_three}"
        holder.itemView.tv_health.text = healthText

        //Starting mana
        val startingManaText = "Starting mana : ${item.starting_mana}"
        holder.itemView.tv_starting_mana.text = startingManaText

        //Range
        val rangeText = "Range : ${item.range}"
        holder.itemView.tv_range.text = rangeText

        //Attack damage
        val attackDamageText =
            "Attack damage : ${item.attack_damage_lvl_one} " +
                    "/ ${item.attack_damage_lvl_two} " +
                    "/ ${item.attack_damage_lvl_three}"
        holder.itemView.tv_attack_damage.text = attackDamageText

        //Attack speed
        val attackSpeedText = "Attack speed : ${item.attack_speed}"
        holder.itemView.tv_attack_speed.text = attackSpeedText

        //Armor
        val armorText = "Armor : ${item.armor}"
        holder.itemView.tv_armor.text = armorText

        //DPS
        val dpsText = "DPS : ${item.dps_lvl_one} / ${item.dps_lvl_two} / ${item.dps_lvl_three}"
        holder.itemView.tv_dps.text = dpsText

        //Magic resist
        val magicResistText = "Magic resist : ${item.magic_resist}"
        holder.itemView.tv_magic_resist.text = magicResistText

        //Items
        val rvItems = holder.itemView.rv_items
        val adapterItems = TestItemsAdapter()
        rvItems.adapter = adapterItems
        rvItems.addItemDecoration(
            ItemOffsetDecoration(
                holder.itemView.context,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )
        itemsViewModel.getItemsFromChampion(item.id).observe(lifecycleOwner, Observer { items ->
            adapterItems.update(items)
        })

        //Closer: Items
        val arrowSection = holder.itemView.iv_arrow_section
        arrowSection.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context,
                if (rvItems.isVisible) R.drawable.ic_arrow_drop_up_black_24dp
                else R.drawable.ic_arrow_drop_down_black_24dp
            )
        )
        holder.itemView.rl_section_closer.setOnClickListener {
            if (rvItems.isVisible) {
                rvItems.visibility = View.GONE
                arrowSection.setImageDrawable(
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.ic_arrow_drop_down_black_24dp
                    )
                )
            } else {
                rvItems.visibility = View.VISIBLE
                arrowSection.setImageDrawable(
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.ic_arrow_drop_up_black_24dp
                    )
                )
            }
        }
    }

    fun update(newData: List<Champion>) {
        data = newData
        notifyDataSetChanged()
    }

}