package yb.lol.tft.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import yb.lol.tft.databases.TFTDatabase
import yb.lol.tft.models.entities.Item
import yb.lol.tft.repositories.ItemRepository

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    val repository: ItemRepository

    val allItems: LiveData<List<Item>>

    init {
        val database = TFTDatabase.getDatabase(application, viewModelScope)
        val itemDao = database.getItemDao()
        val championItemJoinDao = database.getChampionItemJoinDao()
        repository = ItemRepository(itemDao, championItemJoinDao)
        allItems = repository.allItems
    }

    fun getItemsFromChampion(championId: Int) = repository.itemsFromChampion(championId)

}