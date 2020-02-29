package yb.lol.tft.models.template

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import yb.lol.tft.R
import yb.lol.tft.models.Item
import yb.lol.tft.models.Rank
import yb.lol.tft.models.Stat

class TemplateItems(ctx: Context) {

    val drawable : Drawable = ContextCompat.getDrawable(ctx, R.drawable.ic_brush_black_24dp)!!

    val guardianAngel = Item(
        id = 3,
        image = drawable,
        name = "Guardian Angel",
        rank = Rank.S,
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
                id = 0,
                image = drawable,
                name = "B.F. Sword",
                stats = arrayListOf(
                    Stat(
                        logo = drawable,
                        desc = "+15"
                    )
                ),
                desc = null,
                rank = Rank.A,
                recipe = null
            ),
            Item(
                id = 1,
                image = drawable,
                name = "Chain Vest",
                stats = arrayListOf(
                    Stat(
                        logo = drawable,
                        desc = "+25"
                    )
                ),
                desc = null,
                rank = Rank.B,
                recipe = null
            )
        )
    )
}