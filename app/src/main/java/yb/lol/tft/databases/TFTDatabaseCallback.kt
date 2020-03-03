package yb.lol.tft.databases

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.*
import yb.lol.tft.entities.join.*
import kotlin.coroutines.CoroutineContext

class TFTDatabaseCallback(
    private val dbInstance: TFTDatabase?,
    private val context: Context,
    private val scope: CoroutineScope
) : RoomDatabase.Callback(), CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        dbInstance?.let {
            scope.launch {
                populateDatabase()
            }
        }
    }

    private suspend fun populateDatabase() = withContext(Dispatchers.IO) {
        //Entities
        val database = TFTDatabase.getDatabase(context, scope)
        val compositionDao = database.getCompositionDao()
        val championDao = database.getChampionDao()
        val typeDao = database.getTypeDao()
        val itemDao = database.getItemDao()
        //Joins
        val compositionTypeJoinDao = database.getCompositionTypeJoinDao()
        val compositionChampionJoinDao = database.getCompositionChampionJoinDao()
        val championTypeJoinDao = database.getChampionTypeJoinDao()
        val championItemJoinDao = database.getChampionItemJoinDao()

        //Always delete Join tables first
        compositionTypeJoinDao.deleteAll()
        compositionChampionJoinDao.deleteAll()
        championTypeJoinDao.deleteAll()
        championItemJoinDao.deleteAll()
        //Then delete 'normal' tables
        compositionDao.deleteAll()
        championDao.deleteAll()
        typeDao.deleteAll()
        itemDao.deleteAll()

        //Insert compositions
        compositionDao.insertComposition(compositionShadowRanger)
        //Insert champion Kindred
        championDao.insert(championKindred)
        //Insert types
        typeDao.insertType(typeShadow)
        typeDao.insertType(typeRanger)
        //Insert items
        itemDao.insert(itemRabadon)
        itemDao.insert(itemFirecannon)
        itemDao.insert(itemSeraph)
        itemDao.insert(itemInfinityEdge)
        itemDao.insert(itemJeweledGauntlet)

        //Join composition Shadow Ranger with types Shadow and Ranger
        compositionTypeJoinDao.insert(CompositionTypeJoin(42, 100))
        compositionTypeJoinDao.insert(CompositionTypeJoin(42, 101))

        //Join composition Shadow Ranger with champion Kindred
        compositionChampionJoinDao.insert(CompositionChampionJoin(42, 200))

        //Join champion Kindred with types Shadow and Ranger
        championTypeJoinDao.insert(ChampionTypeJoin(200, 100))
        championTypeJoinDao.insert(ChampionTypeJoin(200, 101))

        //Join champion Kindred with items Rabadon, Firecannon and Seraph
        championItemJoinDao.insert(ChampionItemJoin(200, 300))
        championItemJoinDao.insert(ChampionItemJoin(200, 301))
        championItemJoinDao.insert(ChampionItemJoin(200, 302))

        //Join items Infinity Edge, Jeweled Gauntlet and Seraph with Kindred in Shadow Ranger composition
        //todo
    }
}