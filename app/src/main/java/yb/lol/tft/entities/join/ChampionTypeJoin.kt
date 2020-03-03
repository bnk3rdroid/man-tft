package yb.lol.tft.entities.join

import androidx.room.Entity
import androidx.room.ForeignKey
import yb.lol.tft.entities.Champion
import yb.lol.tft.entities.Type

@Entity(
    tableName = "champions_types_join",
    primaryKeys = ["champion_id", "type_id"],
    foreignKeys = [
        ForeignKey(
            entity = Champion::class,
            parentColumns = ["id"],
            childColumns = ["champion_id"]
        ),
        ForeignKey(
            entity = Type::class,
            parentColumns = ["id"],
            childColumns = ["type_id"]
        )
    ]
)
data class ChampionTypeJoin(
    val champion_id: Int = 0,
    val type_id: Int = 0
)