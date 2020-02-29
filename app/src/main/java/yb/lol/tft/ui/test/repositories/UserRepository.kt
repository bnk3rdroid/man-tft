package yb.lol.tft.ui.test.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.ui.test.room.User
import yb.lol.tft.ui.test.room.UserDAO

class UserRepository(private val userDao: UserDAO) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insertUsers(user)
    }
}