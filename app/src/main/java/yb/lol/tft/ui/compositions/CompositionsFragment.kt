package yb.lol.tft.ui.compositions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import yb.lol.tft.R
import yb.lol.tft.models.Composition
import yb.lol.tft.models.template.TemplateCompositions
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

        view.findViewById<RecyclerView>(R.id.champions_rv).apply {
            val fragment = this@CompositionsFragment
            adapter = CompositionsAdapter()
            addItemDecoration(ItemOffsetDecoration(context, R.dimen.item_decoration_vertical_margin))

            compositionsViewModel = ViewModelProvider(fragment).get(CompositionsViewModel::class.java)
            val observer = Observer<ArrayList<Composition>> {
                (adapter as CompositionsAdapter).update(it)
            }
            compositionsViewModel.compositions.observe(viewLifecycleOwner, observer)
        }

        view.findViewById<Button>(R.id.champion_update_btn).setOnClickListener {
            compositionsViewModel.compositions.value = arrayListOf(
                getTemplateComposition(context),
                getTemplateComposition(context))
        }

        return view
    }

    private fun getTemplateComposition(ctx: Context) = TemplateCompositions(ctx = ctx).sComp

}