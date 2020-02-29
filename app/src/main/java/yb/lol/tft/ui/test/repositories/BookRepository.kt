package yb.lol.tft.ui.test.repositories

import androidx.lifecycle.LiveData
import yb.lol.tft.ui.test.room.Book
import yb.lol.tft.ui.test.room.BookDAO

class BookRepository(private val bookDao: BookDAO) {

    val allBooks: LiveData<List<Book>> = bookDao.getAllBooks()

    fun booksWithUserId(userId: Int): LiveData<List<Book>> = bookDao.getBooksWithUserId(userId)

    fun insert(book: Book) {
        bookDao.insertBooks(book)
    }
}