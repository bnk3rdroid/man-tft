package yb.lol.tft.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomWarnings
import yb.lol.tft.entities.Composition
import yb.lol.tft.entities.Type
import yb.lol.tft.entities.join.CompositionTypeJoin

@Dao
interface CompositionTypeJoinDAO {

    @Insert
    suspend fun insert(compositionTypeJoin: CompositionTypeJoin)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from compositions inner join compositions_types_join on compositions.id=compositions_types_join.composition_id where compositions_types_join.type_id=:typeId")
    fun getCompositionsWithType(typeId: Int): LiveData<List<Composition>>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from types inner join compositions_types_join on types.id=compositions_types_join.type_id where compositions_types_join.composition_id=:compositionId")
    fun getTypesFromComposition(compositionId: Int): LiveData<List<Type>>

    @Query("delete from compositions_types_join")
    fun deleteAll()

}