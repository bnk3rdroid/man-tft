package yb.lol.tft.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yb.lol.tft.entities.Composition

@Dao
interface CompositionDAO {

    @Insert
    suspend fun insertComposition(composition: Composition)

    @Query("select * from compositions")
    fun getAllCompositions(): LiveData<List<Composition>>

    @Query("delete from compositions")
    fun deleteAll()

}