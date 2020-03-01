package yb.lol.tft.ui.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user_test.view.*
import yb.lol.tft.R
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.ui.test.viewmodels.BooksViewModel
import yb.lol.tft.ui.test.room.User

class UsersAdapter(
    private val owner: ViewModelStoreOwner,
    private val lifecycleOwner: LifecycleOwner
) :
    ATestAdapter<User, UsersAdapter.UsersVH>() {

    class UsersVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var booksViewModel: BooksViewModel
    private lateinit var ctx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersVH {
        booksViewModel = ViewModelProvider(owner).get(BooksViewModel::class.java)
        ctx = parent.context
        return UsersVH(
            LayoutInflater.from(ctx).inflate(
                R.layout.item_user_test,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        val item = data[position]

        holder.itemView.tv_user_name.text = item.name

        val age = "(${item.age} ans)"
        holder.itemView.tv_user_age.text = age

        val recyclerView = holder.itemView.rv_books
        val adapter = BooksAdapter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            ItemOffsetDecoration(
                ctx,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )

        booksViewModel.booksWithUserId(item.user_id).observe(lifecycleOwner, Observer { books ->
            adapter.update(books)
        })
    }

}