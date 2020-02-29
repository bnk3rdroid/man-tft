package yb.lol.tft.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "effects")
data class Effect(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val level: Int,
    val desc: String
)