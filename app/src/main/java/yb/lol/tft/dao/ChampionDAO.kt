package yb.lol.tft.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.entities.Champion

@Dao
interface ChampionDAO {

    @Insert
    suspend fun insert(champion: Champion)

    @Query("select * from champions")
    fun getAllChampions(): LiveData<List<Champion>>

    @Query("delete from champions")
    fun deleteAll()
}