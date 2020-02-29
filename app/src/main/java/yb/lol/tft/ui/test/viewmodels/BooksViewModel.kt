package yb.lol.tft.ui.test.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import yb.lol.tft.ui.test.repositories.BookRepository
import yb.lol.tft.ui.test.room.Book
import yb.lol.tft.ui.test.room.TestDatabase

class BooksViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val allBooks: LiveData<List<Book>>

    init {
        val bookDao = TestDatabase.getDatabase(application, viewModelScope).BookDAO()
        repository = BookRepository(bookDao)
        allBooks = repository.allBooks
    }

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }

    fun booksWithUserId(userId: Int): LiveData<List<Book>> = repository.booksWithUserId(userId)

}