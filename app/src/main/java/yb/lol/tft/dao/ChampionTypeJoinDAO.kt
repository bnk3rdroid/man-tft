package yb.lol.tft.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.entities.Champion
import yb.lol.tft.entities.Type
import yb.lol.tft.entities.join.ChampionTypeJoin

@Dao
interface ChampionTypeJoinDAO {

    @Insert
    suspend fun insert(championTypeJoin: ChampionTypeJoin)

    @Query("select * from types inner join champions_types_join on types.id=champions_types_join.type_id where champions_types_join.champion_id=:championId")
    fun getTypesFromChampion(championId: Int): LiveData<List<Type>>

    @Query("select * from champions inner join champions_types_join on champions.id=champions_types_join.champion_id where champions_types_join.type_id=:typeId")
    fun getChampionsWithType(typeId: Int): LiveData<List<Champion>>

    @Query("delete from champions_types_join")
    fun deleteAll()

}