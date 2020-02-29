package yb.lol.tft.ui.test.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import yb.lol.tft.ui.test.repositories.UserRepository
import yb.lol.tft.ui.test.room.TestDatabase
import yb.lol.tft.ui.test.room.User

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        val userDao = TestDatabase.getDatabase(application, viewModelScope).UserDAO()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

}