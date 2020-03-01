package yb.lol.tft.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.models.entities.Type

@Dao
interface TypeDAO {

    @Insert
    suspend fun insertType(type: Type)

    @Query("select * from types")
    fun getAllTypes(): LiveData<List<Type>>

    @Query("delete from types")
    fun deleteAll()

}