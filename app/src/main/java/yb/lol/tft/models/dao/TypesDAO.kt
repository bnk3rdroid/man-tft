package yb.lol.tft.models.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface TypesDAO {

    @Transaction
    @Query("SELECT * FROM types")
    fun getTypesWithEffects(): ArrayList<TypeWithEffects>

}