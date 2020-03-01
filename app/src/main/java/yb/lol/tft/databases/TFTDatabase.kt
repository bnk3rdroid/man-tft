package yb.lol.tft.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import yb.lol.tft.databases.dao.*
import yb.lol.tft.models.entities.*
import yb.lol.tft.models.entities.join.ChampionItemJoin
import yb.lol.tft.models.entities.join.ChampionTypeJoin
import yb.lol.tft.models.entities.join.CompositionChampionJoin
import yb.lol.tft.models.entities.join.CompositionTypeJoin

@Database(
    entities = [
        Composition::class,
        Champion::class,
        Item::class,
        ItemRecipe::class,
        Type::class,
        CompositionTypeJoin::class,
        CompositionChampionJoin::class,
        ChampionTypeJoin::class,
        ChampionItemJoin::class
    ],
    version = 8,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TFTDatabase : RoomDatabase() {

    abstract fun getCompositionDao(): CompositionDAO
    abstract fun getChampionDao(): ChampionDAO
    abstract fun getTypeDao(): TypeDAO
    abstract fun getItemDao(): ItemDAO
    abstract fun getCompositionTypeJoinDao(): CompositionTypeJoinDAO
    abstract fun getCompositionChampionJoinDao(): CompositionChampionJoinDAO
    abstract fun getChampionTypeJoinDao(): ChampionTypeJoinDAO
    abstract fun getChampionItemJoinDao(): ChampionItemJoinDAO

    companion object {

        @Volatile
        private var INSTANCE: TFTDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): TFTDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TFTDatabase::class.java,
                    "test_database"
                )
                    .addCallback(
                        TFTDatabaseCallback(
                            context,
                            scope
                        )
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

    private class TFTDatabaseCallback(
        private val context: Context,
        private val scope: CoroutineScope
    ) :
        RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch {
                    val database =
                        getDatabase(
                            context,
                            scope
                        )
                    val compositionDao = database.getCompositionDao()
                    val championDao = database.getChampionDao()
                    val typeDao = database.getTypeDao()
                    val itemDao = database.getItemDao()
                    val compositionTypeJoinDao = database.getCompositionTypeJoinDao()
                    val compositionChampionJoinDao = database.getCompositionChampionJoinDao()
                    val championTypeJoinDao = database.getChampionTypeJoinDao()
                    val championItemJoinDao = database.getChampionItemJoinDao()
                    populateDatabase(
                        compositionDao,
                        championDao,
                        typeDao,
                        itemDao,
                        compositionTypeJoinDao,
                        compositionChampionJoinDao,
                        championTypeJoinDao,
                        championItemJoinDao
                    )
                }
            }
        }

        suspend fun populateDatabase(
            compositionDao: CompositionDAO,
            championDao: ChampionDAO,
            typeDao: TypeDAO,
            itemDao: ItemDAO,
            compositionTypeJoinDao: CompositionTypeJoinDAO,
            compositionChampionJoinDao: CompositionChampionJoinDAO,
            championTypeJoinDao: ChampionTypeJoinDAO,
            championItemJoinDao: ChampionItemJoinDAO
        ) = withContext(Dispatchers.IO) {

            compositionTypeJoinDao.deleteAll()
            compositionChampionJoinDao.deleteAll()
            championTypeJoinDao.deleteAll()
            championItemJoinDao.deleteAll()

            compositionDao.deleteAll()
            championDao.deleteAll()
            typeDao.deleteAll()
            itemDao.deleteAll()

            val compositionShadowRanger = Composition(
                id = 42,
                name = "Shadow Rangers",
                rank = Rank.S
            )

            val championKindred = Champion(
                id = 200,
                name = "Kindred",
                cost = 3,
                mana = 35,
                health_lvl_one = 650,
                health_lvl_two = 1170,
                health_lvl_three = 2106,
                starting_mana = 0,
                range = 3,
                attack_damage_lvl_one = 55,
                attack_damage_lvl_two = 99,
                attack_damage_lvl_three = 198,
                attack_speed = 0.75f,
                armor = 20,
                dps_lvl_one = 41,
                dps_lvl_two = 74,
                dps_lvl_three = 149,
                magic_resist = 20
            )

            val typeShadow = Type(
                id = 100,
                name = "Shadow",
                desc = "Shadow champions deal increased damage."
            )

            val typeRanger = Type(
                id = 101,
                name = "Ranger",
                desc = "Rangers have a chance to gain double attack speed."
            )

            val itemRabadon = Item(
                id = 300,
                name = "Rabadon's Deathcap",
                rank = Rank.A,
                desc = "Increases ability power by 75%."
            )

            val itemFirecannon = Item(
                id = 301,
                name = "Rapid Firecannon",
                rank = Rank.A,
                desc = "Attack range is double."
            )

            val itemSeraph = Item(
                id = 302,
                name = "Seraph's Embrace",
                rank = Rank.S,
                desc = "Regain 20 mana each time a spell is cast."
            )

            compositionDao.insertComposition(compositionShadowRanger)

            championDao.insert(championKindred)

            typeDao.insertType(typeShadow)
            typeDao.insertType(typeRanger)

            itemDao.insert(itemRabadon)
            itemDao.insert(itemFirecannon)
            itemDao.insert(itemSeraph)

            compositionTypeJoinDao.insert(
                CompositionTypeJoin(42, 100)
            )
            compositionTypeJoinDao.insert(
                CompositionTypeJoin(42, 101)
            )

            compositionChampionJoinDao.insert(
                CompositionChampionJoin(42, 200)
            )

            championTypeJoinDao.insert(
                ChampionTypeJoin(200, 100)
            )
            championTypeJoinDao.insert(
                ChampionTypeJoin(200, 101)
            )

            championItemJoinDao.insert(
                ChampionItemJoin(200, 300)
            )
            championItemJoinDao.insert(
                ChampionItemJoin(200, 301)
            )
            championItemJoinDao.insert(
                ChampionItemJoin(200, 302)
            )

        }
    }

}