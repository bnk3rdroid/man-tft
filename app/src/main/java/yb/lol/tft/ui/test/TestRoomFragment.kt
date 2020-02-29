package yb.lol.tft.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_test_room.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import yb.lol.tft.R
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.ui.test.adapter.UsersAdapter
import yb.lol.tft.ui.test.room.TestDatabase
import yb.lol.tft.ui.test.viewmodels.UsersViewModel

class TestRoomFragment : Fragment() {

    private lateinit var database: TestDatabase
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_room, container, false)

        database = TestDatabase.getDatabase(
            view.context.applicationContext,
            CoroutineScope(Dispatchers.IO)
        )

        val recyclerView = view.rv_users
        val adapter = UsersAdapter(this, viewLifecycleOwner)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            ItemOffsetDecoration(
                view.context,
                R.dimen.item_decoration_vertical_margin,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )

        usersViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        usersViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            adapter.update(users)
        })

        return view
    }

}