package yb.lol.tft.repositories

import yb.lol.tft.dao.ChampionDAO
import yb.lol.tft.dao.ChampionItemJoinDAO
import yb.lol.tft.dao.CompositionChampionJoinDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChampionRepository @Inject constructor(
    private val championDAO: ChampionDAO,
    private val compositionChampionJoinDao: CompositionChampionJoinDAO,
    private val championItemJoinDao: ChampionItemJoinDAO
) {

    fun allChampions() = championDAO.getAllChampions()

    fun championsFromComposition(compositionId: Int) =
        compositionChampionJoinDao.getChampionsFromComposition(compositionId)

    fun championsWithItem(itemId: Int) = championItemJoinDao.getChampionsWithItem(itemId)

}