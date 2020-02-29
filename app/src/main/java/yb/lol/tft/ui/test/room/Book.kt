package yb.lol.tft.ui.test.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) val book_id: Int,
    @ForeignKey(
        entity = User::class,
        parentColumns = ["user_id"],
        childColumns = ["book_user_id"]
    ) val book_user_id: Int?,
    val title: String?,
    val author: String?
)