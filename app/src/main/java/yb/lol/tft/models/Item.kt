package yb.lol.tft.models

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
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Ignore val image: Drawable?,
    val name: String?,
    val rank: Rank?,
    val stats: ArrayList<Stat>?,
    val desc: String?,
    val recipe: ArrayList<Item>?
)