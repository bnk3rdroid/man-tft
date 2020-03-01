package yb.lol.tft.models.entities

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "types",
    indices = [Index(
        value = ["name"],
        unique = true
    )]
)
data class Type(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var desc: String = "",
    @Ignore var logo: Drawable? = null
)