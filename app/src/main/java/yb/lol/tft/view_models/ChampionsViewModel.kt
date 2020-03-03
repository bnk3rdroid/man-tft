package yb.lol.tft.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import yb.lol.tft.databases.TFTDatabase
import yb.lol.tft.entities.Champion
import yb.lol.tft.repositories.ChampionRepository

class ChampionsViewModel(application: Application) : AndroidViewModel(application) {

    val repository: ChampionRepository
    val allChampions: LiveData<List<Champion>>

    init {
        val database = TFTDatabase.getDatabase(application, viewModelScope)
        val championDao = database.getChampionDao()
        val compositionChampionJoinDao = database.getCompositionChampionJoinDao()
        val championItemJoinDao = database.getChampionItemJoinDao()
        repository =
            ChampionRepository(championDao, compositionChampionJoinDao, championItemJoinDao)
        allChampions = repository.allChampions()
    }

    fun championsFromComposition(compositionId: Int) =
        repository.championsFromComposition(compositionId)

    fun championsWithItem(itemId: Int) = repository.championsWithItem(itemId)

}