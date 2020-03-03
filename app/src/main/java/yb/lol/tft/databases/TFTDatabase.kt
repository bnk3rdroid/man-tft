package yb.lol.tft.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.CoroutineScope
import yb.lol.tft.dao.*
import yb.lol.tft.entities.*
import yb.lol.tft.entities.join.ChampionItemJoin
import yb.lol.tft.entities.join.ChampionTypeJoin
import yb.lol.tft.entities.join.CompositionChampionJoin
import yb.lol.tft.entities.join.CompositionTypeJoin

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
                            INSTANCE,
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

}