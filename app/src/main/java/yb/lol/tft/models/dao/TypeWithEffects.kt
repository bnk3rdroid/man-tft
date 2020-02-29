package yb.lol.tft.models.dao

import androidx.room.Embedded
import androidx.room.Relation
import yb.lol.tft.models.Effect
import yb.lol.tft.models.Type

class TypeWithEffects(
    @Embedded val type: Type,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val effects: ArrayList<Effect>
)