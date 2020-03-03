package yb.lol.tft.ui.types

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_type_small.view.*
import yb.lol.tft.R
import yb.lol.tft.entities.Type

class TypesSmallAdapter : RecyclerView.Adapter<TypesSmallAdapter.TypesSmallViewHolder>() {

    private var data: List<Type> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesSmallViewHolder {
        return TypesSmallViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_type_small,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: TypesSmallViewHolder, position: Int) {
        val item = data[position]

        val defaultDrawable = ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_book_black_24dp)
        holder.itemView.type_small_logo.setImageDrawable(item.logo ?: defaultDrawable)
    }

    fun update(newData: List<Type>) {
        data = newData
        notifyDataSetChanged()
    }

    class TypesSmallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}