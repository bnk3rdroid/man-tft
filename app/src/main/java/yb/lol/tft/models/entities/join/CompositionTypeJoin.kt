package yb.lol.tft.models.entities.join

import androidx.room.Entity
import androidx.room.ForeignKey
import yb.lol.tft.models.entities.Composition
import yb.lol.tft.models.entities.Type

@Entity(
    tableName = "compositions_types_join",
    primaryKeys = ["composition_id", "type_id"],
    foreignKeys = [
        ForeignKey(
            entity = Composition::class,
            parentColumns = ["id"],
            childColumns = ["composition_id"]
        ),
        ForeignKey(
            entity = Type::class,
            parentColumns = ["id"],
            childColumns = ["type_id"]
        )
    ]
)
data class CompositionTypeJoin(
    var composition_id: Int = 0,
    var type_id: Int = 0
)