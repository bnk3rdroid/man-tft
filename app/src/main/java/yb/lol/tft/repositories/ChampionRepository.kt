package yb.lol.tft.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.databases.dao.ChampionDAO
import yb.lol.tft.databases.dao.ChampionItemJoinDAO
import yb.lol.tft.databases.dao.CompositionChampionJoinDAO
import yb.lol.tft.models.entities.Champion

class ChampionRepository(
    championDAO: ChampionDAO,
    private val compositionChampionJoinDao: CompositionChampionJoinDAO,
    private val championItemJoinDao: ChampionItemJoinDAO
) {

    val allChampions: LiveData<List<Champion>> = championDAO.getAllChampions()

    fun championsFromComposition(compositionId: Int) =
        compositionChampionJoinDao.getChampionsFromComposition(compositionId)

    fun championsWithItem(itemId: Int) = championItemJoinDao.getChampionsWithItem(itemId)

}