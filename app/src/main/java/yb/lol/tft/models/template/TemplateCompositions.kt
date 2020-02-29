package yb.lol.tft.models.template

import android.content.Context
import yb.lol.tft.models.Composition
import yb.lol.tft.models.Rank

class TemplateCompositions(ctx: Context) {

    val sComp = getSComp(ctx)

    private fun getSComp(ctx: Context): Composition {
        val ga = TemplateItems(ctx).guardianAngel
        val shadow = TemplateTypes(ctx).shadowType
        val mage = TemplateTypes(ctx).magesType
        val veigar = TemplateChampions(ctx, arrayListOf(ga, ga, ga), arrayListOf(shadow, mage)).veigar
        val comp = Composition(
            id = 0,
            name = "Shadow Mages",
            types = arrayListOf(TemplateTypes(ctx).shadowType, TemplateTypes(ctx).magesType),
            rank = Rank.S,
            optimalChampions = arrayListOf(veigar, veigar, veigar, veigar, veigar, veigar, veigar, veigar),
            carries = mapOf(),
            coreChampions = arrayListOf(veigar),
            alternatives = null
        )
        for (champion in comp.optimalChampions) {
            for (carryChampion in comp.carries) {
                if (carryChampion.key.name == champion.name) {
                    champion.carryItems = carryChampion.value
                }
            }
        }
        return comp
    }

}