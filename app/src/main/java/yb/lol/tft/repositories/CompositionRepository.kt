package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.databases.dao.CompositionDAO
import yb.lol.tft.databases.dao.CompositionTypeJoinDAO
import yb.lol.tft.models.entities.Composition

class CompositionRepository(
    compositionDao: CompositionDAO,
    private val compositionTypeJoinDao: CompositionTypeJoinDAO
) {

    val allCompositions: LiveData<List<Composition>> = compositionDao.getAllCompositions()

    fun compositionsWithTypes(typeId: Int): LiveData<List<Composition>> =
        compositionTypeJoinDao.getCompositionsWithType(typeId)

}