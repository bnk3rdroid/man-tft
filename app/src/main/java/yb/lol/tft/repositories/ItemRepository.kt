package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.dao.ChampionItemJoinDAO
import yb.lol.tft.dao.ItemDAO
import yb.lol.tft.entities.Item

class ItemRepository(
    itemDao: ItemDAO,
    private val championItemJoinDao: ChampionItemJoinDAO
) {

    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    fun itemsFromChampion(championId: Int) = championItemJoinDao.getItemsFromChampions(championId)

}