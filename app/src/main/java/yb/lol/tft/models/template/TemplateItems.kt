package yb.lol.tft.models.template

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.Item
import yb.lol.tft.models.Stat

class TemplateItems(ctx: Context) {

    val drawable : Drawable = ContextCompat.getDrawable(ctx, R.drawable.ic_menu_camera)!!

    val guardianAngel = Item(
        image = drawable,
        name = "Guardian Angel",
        ranking = 'S',
        stats = arrayListOf(
            Stat(
                logo = drawable,
                desc = "+15"
            ),
            Stat(
                logo = drawable,
                desc = "+25"
            )
        ),
        desc = "Upon Death, cleanses negative effect and revives after 2 seconds with 400 health.",
        recipe = arrayListOf(
            Item(
                image = drawable,
                name = "B.F. Sword",
                stats = arrayListOf(
                    Stat(
                        logo = drawable,
                        desc = "+15"
                    )
                ),
                desc = null,
                ranking = 'A',
                recipe = null
            ),
            Item(
                image = drawable,
                name = "Chain Vest",
                stats = arrayListOf(
                    Stat(
                        logo = drawable,
                        desc = "+25"
                    )
                ),
                desc = null,
                ranking = 'B',
                recipe = null
            )
        )
    )
}