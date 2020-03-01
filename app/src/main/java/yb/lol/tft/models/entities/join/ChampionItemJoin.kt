package yb.lol.tft.models.entities.join

import androidx.room.Entity
import androidx.room.ForeignKey
import yb.lol.tft.models.entities.Champion
import yb.lol.tft.models.entities.Item

@Entity(
    tableName = "champions_items_join",
    primaryKeys = ["champion_id", "item_id"],
    foreignKeys = [
        ForeignKey(
            entity = Champion::class,
            parentColumns = ["id"],
            childColumns = ["champion_id"]
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"]
        )
    ]
)
data class ChampionItemJoin(
    val champion_id: Int = 0,
    val item_id: Int = 0
)