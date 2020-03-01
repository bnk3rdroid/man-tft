package yb.lol.tft.models.entities

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
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var cost: Int = 0,
    var mana: Int = 0,
    var health_lvl_one: Int = 0,
    var health_lvl_two: Int = 0,
    var health_lvl_three: Int = 0,
    var starting_mana: Int = 0,
    var range: Int = 0,
    var attack_damage_lvl_one: Int = 0,
    var attack_damage_lvl_two: Int = 0,
    var attack_damage_lvl_three: Int = 0,
    var attack_speed: Float = 0.0f,
    var armor: Int? = 0,
    var dps_lvl_one: Int = 0,
    var dps_lvl_two: Int = 0,
    var dps_lvl_three: Int = 0,
    var magic_resist: Int = 0,
    @Ignore var image: Drawable? = null
)