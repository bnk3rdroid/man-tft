package yb.lol.tft.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "compositions",
    indices = [Index(
        value = ["name"],
        unique = true
    )]
)
data class Composition(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var rank: Rank = Rank.UNKNOWN
)