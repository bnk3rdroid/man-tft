package yb.lol.tft.models.template

import android.content.Context
import yb.lol.tft.models.Composition
import yb.lol.tft.models.Rank

class TemplateCompositions(ctx: Context) {

    val sComp = getSComp(ctx)

    private fun getSComp(ctx: Context): Composition {
        val ga = TemplateItems(ctx).guardianAngel
        val shadow = TemplateTypes(ctx).shadowType
        val mage = TemplateTypes(ctx).mageType
        val veigar = TemplateChampions(ctx, arrayListOf(ga), arrayListOf(shadow, mage)).veigar
        return Composition(
            name = "Shadow Mages",
            types = arrayListOf(TemplateTypes(ctx).shadowType, TemplateTypes(ctx).mageType),
            rank = Rank.S,
            optimalChampions = arrayListOf(veigar),
            carries = mapOf(veigar to arrayListOf(ga)),
            coreChampions = arrayListOf(veigar),
            alternatives = null
        )
    }

}