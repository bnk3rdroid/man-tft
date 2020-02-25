package yb.lol.tft.models

import android.graphics.drawable.Drawable

data class Item(
    val image: Drawable,
    val name: String,
    val ranking: Char,
    val stats: ArrayList<Stat>,
    val desc: String?,
    val recipe: ArrayList<Item>?
)