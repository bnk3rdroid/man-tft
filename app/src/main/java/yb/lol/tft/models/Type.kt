package yb.lol.tft.models

import android.graphics.drawable.Drawable

data class Type(
    val logo : Drawable,
    val name : String,
    val desc : String,
    val effects : ArrayList<Effect>
)