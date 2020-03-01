package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.databases.dao.ChampionTypeJoinDAO
import yb.lol.tft.databases.dao.CompositionTypeJoinDAO
import yb.lol.tft.databases.dao.TypeDAO
import yb.lol.tft.models.entities.Type

class TypeRepository(
    typeDAO: TypeDAO,
    private val compositionTypeJoinDao: CompositionTypeJoinDAO,
    private val championTypeJoinDao: ChampionTypeJoinDAO
) {

    val allTypes: LiveData<List<Type>> = typeDAO.getAllTypes()

    fun typesFromComposition(compositionId: Int): LiveData<List<Type>> =
        compositionTypeJoinDao.getTypesFromComposition(compositionId)

    fun typesFromChampion(championId: Int): LiveData<List<Type>> =
        championTypeJoinDao.getTypesFromChampion(championId)

}