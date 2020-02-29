package yb.lol.tft.models

import android.graphics.drawable.Drawable
import androidx.room.*

@Entity(
    tableName = "champions",
    indices = [Index(
        value = ["name"],
        unique = true
    )]
)
data class Champion(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Ignore val image: Drawable?,
    val name: String?,
    var level: Int?,
    val types: ArrayList<Type>?,
    @ColumnInfo(name = "optimal_items") val optimalItems: ArrayList<Item>?,
    @ColumnInfo(name = "carry_items") var carryItems: ArrayList<Item>?,
    val mana: Int?,
    val health: ArrayList<Int>?,
    @ColumnInfo(name = "starting_mana") val startingMana: Int?,
    val range: Int?,
    @ColumnInfo(name = "attack_damage") val attackDamage: ArrayList<Int>?,
    @ColumnInfo(name = "attack_speed") val attackSpeed: Float?,
    val armor: Int?,
    val dps: ArrayList<Int>?,
    @ColumnInfo(name = "magic_resist") val magicResist: Int?,
    val abilities: ArrayList<Ability>?,
    val synergies: Map<Type?, ArrayList<Champion>?>?
)