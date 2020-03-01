package yb.lol.tft.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.models.entities.Champion

@Dao
interface ChampionDAO {

    @Insert
    suspend fun insert(champion: Champion)

    @Query("select * from champions")
    fun getAllChampions(): LiveData<List<Champion>>

    @Query("delete from champions")
    fun deleteAll()
}