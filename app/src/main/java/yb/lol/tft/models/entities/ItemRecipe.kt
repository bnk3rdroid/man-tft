package yb.lol.tft.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class ItemRecipe(
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)