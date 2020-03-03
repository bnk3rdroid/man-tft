package yb.lol.tft.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.entities.Champion
import yb.lol.tft.entities.Item
import yb.lol.tft.entities.join.ChampionItemJoin

@Dao
interface ChampionItemJoinDAO {

    @Insert
    suspend fun insert(championItemJoin: ChampionItemJoin)

    @Query("select * from champions inner join champions_items_join on champions.id=champions_items_join.champion_id where champions_items_join.item_id=:itemId")
    fun getChampionsWithItem(itemId: Int): LiveData<List<Champion>>

    @Query("select * from items inner join champions_items_join on items.id=champions_items_join.item_id where champions_items_join.champion_id=:championId")
    fun getItemsFromChampions(championId: Int): LiveData<List<Item>>

    @Query("delete from champions_items_join")
    fun deleteAll()

}