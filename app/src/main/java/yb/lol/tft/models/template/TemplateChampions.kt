package yb.lol.tft.models.template

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.*

class TemplateChampions(ctx: Context, optimalItems: ArrayList<Item>, types: ArrayList<Type>) {

    val drawable: Drawable = ContextCompat.getDrawable(ctx, R.drawable.ic_menu_camera)!!

    val veigar = Champion(

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
                    logo = drawable,
                    name = "Template",
                    desc = "Template description.",
                    effects = arrayListOf(
                        Effect(3, "Template effect level 3."),
                        Effect(6, "Template effect level 6.")
                    )
                ) to null
            }
        )
    )
}