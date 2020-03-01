package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.databases.dao.ChampionItemJoinDAO
import yb.lol.tft.databases.dao.ItemDAO
import yb.lol.tft.models.entities.Item

class ItemRepository(
    itemDao: ItemDAO,
    private val championItemJoinDao: ChampionItemJoinDAO
) {

    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    fun itemsFromChampion(championId: Int) = championItemJoinDao.getItemsFromChampions(championId)

}