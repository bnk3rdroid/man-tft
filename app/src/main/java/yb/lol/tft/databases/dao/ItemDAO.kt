package yb.lol.tft.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.models.entities.Item

@Dao
interface ItemDAO {

    @Insert
    suspend fun insert(item: Item)

    @Query("select * from items")
    fun getAllItems(): LiveData<List<Item>>

    @Query("delete from items")
    fun deleteAll()

}