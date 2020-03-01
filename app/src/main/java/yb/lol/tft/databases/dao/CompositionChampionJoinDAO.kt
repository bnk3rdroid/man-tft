package yb.lol.tft.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomWarnings
import yb.lol.tft.models.entities.Champion
import yb.lol.tft.models.entities.Composition
import yb.lol.tft.models.entities.join.CompositionChampionJoin

@Dao
interface CompositionChampionJoinDAO {

    @Insert
    suspend fun insert(compositionChampionJoin: CompositionChampionJoin)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from compositions inner join compositions_champions_join on compositions.id=compositions_champions_join.composition_id where compositions_champions_join.champion_id=:championId")
    fun getCompositionsWithChampion(championId: Int): LiveData<List<Composition>>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from champions inner join compositions_champions_join on champions.id=compositions_champions_join.champion_id where compositions_champions_join.composition_id=:compositionId")
    fun getChampionsFromComposition(compositionId: Int): LiveData<List<Champion>>

    @Query("delete from compositions_champions_join")
    fun deleteAll()

}