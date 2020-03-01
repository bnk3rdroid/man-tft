package yb.lol.tft.ui.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_carry_item.view.*
import yb.lol.tft.R
import yb.lol.tft.models.entities.Item

class CarryItemsAdapter : RecyclerView.Adapter<CarryItemsAdapter.CarryItemsViewHolder>() {

    private var data: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarryItemsViewHolder {
        return CarryItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_carry_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CarryItemsViewHolder, position: Int) {
        val item = data[position]
        val defaultDrawable =
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_menu_camera)
        holder.itemView.iv_item.setImageDrawable(item.image ?: defaultDrawable)
    }

    fun update(newData: List<Item>) {
        data = newData
        notifyDataSetChanged()
    }

    class CarryItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}