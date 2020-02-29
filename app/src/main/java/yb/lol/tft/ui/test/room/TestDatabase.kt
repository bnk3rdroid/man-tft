package yb.lol.tft.ui.test.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class, Book::class], version = 5, exportSchema = false)
abstract class TestDatabase : RoomDatabase() {

    abstract fun UserDAO(): UserDAO
    abstract fun BookDAO(): BookDAO

    companion object {

        @Volatile
        private var INSTANCE: TestDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): TestDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TestDatabase::class.java,
                    "test_database"
                )
                    .addCallback(TestDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

    private class TestDatabaseCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.UserDAO(), it.BookDAO())
                }
            }
        }

        suspend fun populateDatabase(userDao: UserDAO, bookDao: BookDAO) {
            userDao.deleteAll()
            bookDao.deleteAll()
            userDao.insertUsers(User(42, "Toto", 10))
            bookDao.insertBooks(Book(0, 42, "Babar", "Jean de Brunhoff"))
        }
    }
}