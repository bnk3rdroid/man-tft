package yb.lol.tft.models.template

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.*

class TemplateChampions(ctx: Context, optimalItems: ArrayList<Item>, types: ArrayList<Type>) {

    val drawable: Drawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_veigar)!!

    val veigar = Champion(
        id = 0,
        image = drawable,
        name = "Veigar",
        level = 3,
        optimalItems = optimalItems,
        mana = 60, health = arrayListOf(600, 1080, 1944), startingMana = 0,
        range = 3, attackDamage = arrayListOf(50, 90, 180), attackSpeed = 0.6f,
        armor = 20, dps = arrayListOf(30, 54, 108), magicResist = 20,
        types = types,
        abilities = arrayListOf(
            Ability(
                logo = drawable,
                effects = mapOf(
                    Ability.Activity.ACTIVE to "Blasts an enemy with magical energy, dealing 325 / 650 / 975 magic damage to the target enemy."
                )
            )
        ),
        synergies = mapOf(
            if (types.size > 1) types[0] to null else {
                Type(
                    id = 0,
                    logo = drawable,
                    name = "Template",
                    desc = "Template description.",
                    effects = arrayListOf(
                        Effect(0,3, "Template effect level 3."),
                        Effect(1,6, "Template effect level 6.")
                    )
                ) to null
            }
        ),
        carryItems = null
    )
}