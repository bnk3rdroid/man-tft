package yb.lol.tft.ui.test.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class ATestAdapter<T, VH : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VH>(),
    ITestAdapter<T> {

    protected var data: List<T> = listOf()

    override fun getItemCount() = data.size

    override fun update(newData: List<T>) {
        data = newData
        notifyDataSetChanged()
    }

}