package yb.lol.tft.models.template

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.Effect
import yb.lol.tft.models.Type

class TemplateTypes(ctx: Context) {

    private val shadowDrawable: Drawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_shadow)!!
    private val magesDrawable: Drawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_mage)!!

    val shadowType = Type(
        id = 0,
        logo = shadowDrawable,
        name = "Shadow",
        desc = "Shadow champions deal increased damage for 0.6 seconds at start, refreshed on takedown.",
        effects = arrayListOf(
            Effect(
                id = 0, level = 3, desc = "+65% increased damage, refresh only on self takedown."
            ),
            Effect(
                id = 1, level = 6, desc = "+165% increased damage, refresh on any shadow takedown."
            )
        )
    )

    val magesType = Type(
        id = 1,
        logo = magesDrawable,
        name = "Mages",
        desc = "Mages have a chance on cast to instead double cast.",
        effects = arrayListOf(
            Effect(
                id = 3, level = 3, desc = "+50% chance to double cast."
            ),
            Effect(
                level = 6,
                id = 4,
                desc = "+100% chance to double cast, and all mages gain 20 bonus ability power."
            )
        )
    )
}