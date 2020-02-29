package yb.lol.tft.ui.test.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val user_id: Int,
    val name: String?,
    val age: Int?
)