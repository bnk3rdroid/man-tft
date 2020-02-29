package yb.lol.tft.ui.types

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_type_small.view.*
import yb.lol.tft.R
import yb.lol.tft.models.Type

class TypesSmallAdapter : RecyclerView.Adapter<TypesSmallAdapter.TypesSmallViewHolder>() {

    private lateinit var ctx: Context
    private var data: ArrayList<Type> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesSmallViewHolder {
        ctx = parent.context
        return TypesSmallViewHolder(
            LayoutInflater.from(ctx).inflate(
                R.layout.item_type_small,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: TypesSmallViewHolder, position: Int) {
        val item = data[position]

        holder.itemView.type_small_logo.setImageDrawable(item.logo)
    }

    fun update(newData: ArrayList<Type>) {
        data = newData
        notifyDataSetChanged()
    }

    class TypesSmallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}