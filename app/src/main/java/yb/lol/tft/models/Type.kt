package yb.lol.tft.models

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "types")
data class Type(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val logo : Drawable,
    val name : String,
    val desc : String,
    val effects : ArrayList<Effect>
) {
    enum class KnownType {
        SHADOW,
        MAGES
    }
}