package yb.lol.tft.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import yb.lol.tft.databases.TFTDatabase
import yb.lol.tft.entities.Type
import yb.lol.tft.repositories.TypeRepository

class TypesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: TypeRepository

    val allTypes: LiveData<List<Type>>

    init {
        val database = TFTDatabase.getDatabase(application, viewModelScope)
        val typeDao = database.getTypeDao()
        val compositionTypeDao = database.getCompositionTypeJoinDao()
        val championTypeDao = database.getChampionTypeJoinDao()
        repository = TypeRepository(typeDao, compositionTypeDao, championTypeDao)
        allTypes = repository.allTypes
    }

    fun typesFromComposition(compositionId: Int): LiveData<List<Type>> =
        repository.typesFromComposition(compositionId)

    fun typesFromChampion(championId: Int): LiveData<List<Type>> =
        repository.typesFromChampion(championId)

}