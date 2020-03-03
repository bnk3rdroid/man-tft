package yb.lol.tft.ui.compositions.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_test_items.view.*
import yb.lol.tft.R
import yb.lol.tft.entities.Item

class TestItemsAdapter : RecyclerView.Adapter<TestItemsAdapter.TestItemsVH>() {

    class TestItemsVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var data: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestItemsVH {
        return TestItemsVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_test_items,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TestItemsVH, position: Int) {
        val item = data[position]

        //Name
        holder.itemView.tv_name.text = item.name

        //Rank
        val rankText = "Rank : ${item.rank.name} tier"
        holder.itemView.tv_rank.text = rankText

        //Description
        val descriptionText = "Description : ${item.desc}"
        holder.itemView.tv_description.text = descriptionText

    }

    fun update(newData: List<Item>) {
        data = newData
        notifyDataSetChanged()
    }
}