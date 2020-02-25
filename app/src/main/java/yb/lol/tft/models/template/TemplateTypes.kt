package yb.lol.tft.models.template

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.Effect
import yb.lol.tft.models.Type

class TemplateTypes(ctx: Context) {

    val drawable: Drawable = ContextCompat.getDrawable(ctx, R.drawable.ic_menu_camera)!!

    val shadowType = Type(
        logo = drawable,
        name = "Shadow",
        desc = "Shadow champions deal increased damage for 0.6 seconds at start, refreshed on takedown.",
        effects = arrayListOf(
            Effect(
                level = 3, desc = "+65% increased damage, refresh only on self takedown."
            ),
            Effect(
                level = 6, desc = "+165% increased damage, refresh on any shadow takedown."
            )
        )
    )

    val mageType = Type(
        logo = drawable,
        name = "Mage",
        desc = "Mages have a chance on cast to instead double cast.",
        effects = arrayListOf(
            Effect(
                level = 3, desc = "+50% chance to double cast."
            ),
            Effect(
                level = 6,
                desc = "+100% chance to double cast, and all mages gain 20 bonus ability power."
            )
        )
    )
}