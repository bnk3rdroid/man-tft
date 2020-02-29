package yb.lol.tft.models.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import yb.lol.tft.models.CompositionWithChampions

@Dao
interface CompositionsDAO {

    @Transaction
    @Query("SELECT * FROM compositions")
    fun getCompositionsWithOptimalChampions() : ArrayList<CompositionWithChampions>

}