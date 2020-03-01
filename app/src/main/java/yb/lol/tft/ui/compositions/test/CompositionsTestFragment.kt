package yb.lol.tft.ui.compositions.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_test_compositions.view.*
import yb.lol.tft.R
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration
import yb.lol.tft.view_models.ChampionsViewModel
import yb.lol.tft.view_models.CompositionsViewModel
import yb.lol.tft.view_models.ItemsViewModel
import yb.lol.tft.view_models.TypesViewModel

class CompositionsTestFragment : Fragment() {

    private lateinit var compositionsViewModel: CompositionsViewModel
    private lateinit var typesViewModel: TypesViewModel
    private lateinit var championsViewModel: ChampionsViewModel
    private lateinit var itemsViewModel: ItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_compositions, container, false)

        val viewModelProvider = ViewModelProvider(this)
        compositionsViewModel = viewModelProvider.get(CompositionsViewModel::class.java)
        championsViewModel = viewModelProvider.get(ChampionsViewModel::class.java)
        typesViewModel = viewModelProvider.get(TypesViewModel::class.java)
        itemsViewModel = viewModelProvider.get(ItemsViewModel::class.java)

        val rvCompositions = view.rv_compositions
        val adapter =
            TestCompositionsAdapter(
                typesViewModel,
                championsViewModel,
                itemsViewModel,
                viewLifecycleOwner
            )
        rvCompositions.adapter = adapter
        rvCompositions.addItemDecoration(
            ItemOffsetDecoration(
                view.context,
                R.dimen.margin_xs,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )

        compositionsViewModel.allCompositions.observe(viewLifecycleOwner, Observer { compositions ->
            adapter.update(compositions)
        })

        return view
    }

}