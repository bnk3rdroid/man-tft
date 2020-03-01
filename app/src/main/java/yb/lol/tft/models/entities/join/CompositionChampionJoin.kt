package yb.lol.tft.models.entities.join

import androidx.room.Entity
import androidx.room.ForeignKey
import yb.lol.tft.models.entities.Champion
import yb.lol.tft.models.entities.Composition

@Entity(
    tableName = "compositions_champions_join",
    primaryKeys = ["composition_id", "champion_id"],
    foreignKeys = [
        ForeignKey(
            entity = Composition::class,
            parentColumns = ["id"],
            childColumns = ["composition_id"]
        ),
        ForeignKey(
            entity = Champion::class,
            parentColumns = ["id"],
            childColumns = ["champion_id"]
        )
    ]
)
data class CompositionChampionJoin(
    var composition_id: Int = 0,
    var champion_id: Int = 0
)