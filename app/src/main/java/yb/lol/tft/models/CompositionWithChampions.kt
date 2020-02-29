package yb.lol.tft.models

import androidx.room.Embedded
import androidx.room.Relation

data class CompositionWithChampions(
    @Embedded val composition: Composition,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val optimalChampions: ArrayList<Champion>
)