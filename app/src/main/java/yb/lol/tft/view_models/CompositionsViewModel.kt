package yb.lol.tft.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import yb.lol.tft.databases.TFTDatabase
import yb.lol.tft.models.entities.Composition
import yb.lol.tft.repositories.CompositionRepository

class CompositionsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CompositionRepository

    var allCompositions: LiveData<List<Composition>>

    init {
        val compositionDao =
            TFTDatabase.getDatabase(application, viewModelScope).getCompositionDao()
        val compositionTypeJoinDao =
            TFTDatabase.getDatabase(application, viewModelScope).getCompositionTypeJoinDao()
        repository = CompositionRepository(compositionDao, compositionTypeJoinDao)
        allCompositions = repository.allCompositions
    }


    fun compositionsWithType(typeId: Int): LiveData<List<Composition>> =
        repository.compositionsWithTypes(typeId)

}