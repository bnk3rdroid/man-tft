package yb.lol.tft.models

import android.graphics.drawable.Drawable

data class Ability(
    val logo: Drawable,
    val effects: Map<Activity, String>
) {
    enum class Activity { PASSIVE, ACTIVE }
}