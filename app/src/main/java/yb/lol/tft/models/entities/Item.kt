package yb.lol.tft.models.entities

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "items",
    indices = [Index(
        value = ["name"],
        unique = true
    )]
)
data class Item(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var rank: Rank = Rank.UNKNOWN,
    var desc: String = "",
    @Ignore var image: Drawable? = null
)