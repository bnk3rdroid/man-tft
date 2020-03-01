package yb.lol.tft.ui.compositions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_compositions.view.*
import yb.lol.tft.R
import yb.lol.tft.ui.recycler_view.ItemOffsetDecoration

class CompositionsFragment : Fragment() {

    private lateinit var compositionsViewModel: CompositionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compositionsViewModel = ViewModelProvider(this).get(CompositionsViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_compositions, container, false)
        val context = view.context

        val rvCompositions = view.rv_compositions
        val adapter = CompositionsAdapter()
        rvCompositions.adapter = adapter
        rvCompositions.addItemDecoration(
            ItemOffsetDecoration(
                context,
                R.dimen.margin_small,
                ItemOffsetDecoration.Orientation.VERTICAL
            )
        )

        compositionsViewModel = ViewModelProvider(this).get(CompositionsViewModel::class.java)
        compositionsViewModel.compositions.observe(viewLifecycleOwner, Observer { compositions ->
            adapter.update(compositions)
        })

        return view
    }

}