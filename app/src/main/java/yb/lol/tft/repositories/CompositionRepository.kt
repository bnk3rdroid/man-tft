package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.dao.CompositionDAO
import yb.lol.tft.dao.CompositionTypeJoinDAO
import yb.lol.tft.entities.Composition

class CompositionRepository(
    compositionDao: CompositionDAO,
    private val compositionTypeJoinDao: CompositionTypeJoinDAO
) {

    val allCompositions: LiveData<List<Composition>> = compositionDao.getAllCompositions()

    fun compositionsWithTypes(typeId: Int): LiveData<List<Composition>> =
        compositionTypeJoinDao.getCompositionsWithType(typeId)

}