package yb.lol.tft.models

import android.graphics.drawable.Drawable

data class Champion(
    val image: Drawable,
    val name: String,
    val level: Int,
    val types: ArrayList<Type>,
    val optimalItems: ArrayList<Item>,
    val mana: Int,
    val health: ArrayList<Int>,
    val startingMana: Int,
    val range: Int,
    val attackDamage: ArrayList<Int>,
    val attackSpeed: Float,
    val armor: Int,
    val dps: ArrayList<Int>,
    val magicResist: Int,
    val abilities: ArrayList<Ability>,
    val synergies: Map<Type, ArrayList<Champion>?>
)