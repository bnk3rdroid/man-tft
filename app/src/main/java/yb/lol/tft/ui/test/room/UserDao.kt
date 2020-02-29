package yb.lol.tft.ui.test.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Query("select * from users order by name asc")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUsers(vararg users: User)

    @Query("delete from users")
    suspend fun deleteAll()
}