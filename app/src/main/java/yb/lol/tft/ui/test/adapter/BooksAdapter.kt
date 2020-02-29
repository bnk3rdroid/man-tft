package yb.lol.tft.ui.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book_test.view.*
import yb.lol.tft.R
import yb.lol.tft.ui.test.room.Book

class BooksAdapter : ATestAdapter<Book, BooksAdapter.BooksVH>() {

    class BooksVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        return BooksVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book_test,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val item = data[position]

        holder.itemView.tv_book_title.text = item.title

        val author = "(${item.author})"
        holder.itemView.tv_book_author.text = author
    }

}