package yb.lol.tft.ui.test.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO {

    @Query("select * from books")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("select * from books where book_user_id=:userId")
    fun getBooksWithUserId(userId: Int): LiveData<List<Book>>

    @Insert
    fun insertBooks(vararg books: Book)

    @Query("delete from books")
    fun deleteAll()

}