package yb.lol.tft.ui.champions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_champions.*
import yb.lol.tft.R
import yb.lol.tft.models.Champion
import yb.lol.tft.models.template.TemplateChampions
import yb.lol.tft.models.template.TemplateItems
import yb.lol.tft.models.template.TemplateTypes

class ChampionsFragment : Fragment() {

    private lateinit var championsViewModel: ChampionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        championsViewModel = ViewModelProviders.of(this).get(ChampionsViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_champions, container, false)
        val context = view.context

        view.findViewById<RecyclerView>(R.id.champions_rv).apply {
            val fragment = this@ChampionsFragment
            layoutManager = GridLayoutManager(fragment.activity, 3)
            adapter = ChampionsAdapter()

            championsViewModel = ViewModelProviders.of(fragment).get(ChampionsViewModel::class.java)
            val observer = Observer<ArrayList<Champion>> {
                (adapter as ChampionsAdapter).update(it)
            }
            championsViewModel.champions.observe(fragment, observer)
        }

        view.findViewById<Button>(R.id.champion_update_btn).setOnClickListener {
            championsViewModel.champions.value = arrayListOf(getTemplateChampion(context))
        }

        return view
    }

    private fun getTemplateChampion(ctx: Context) : Champion = TemplateChampions(
        ctx = ctx,
        optimalItems = arrayListOf(TemplateItems(ctx).guardianAngel),
        types = arrayListOf(
            TemplateTypes(ctx).shadowType,
            TemplateTypes(ctx).mageType
        )
    ).veigar

}