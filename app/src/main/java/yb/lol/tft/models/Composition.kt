package yb.lol.tft.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "compositions")
data class Composition(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val types: ArrayList<Type>,
    val rank: Rank,
    @ColumnInfo(name = "optimal_champions") val optimalChampions: ArrayList<Champion>,
    val carries: Map<Champion, ArrayList<Item>>,
    @ColumnInfo(name = "core_champions") val coreChampions: ArrayList<Champion>,
    val alternatives: Map<ArrayList<Champion>, ArrayList<Champion>>?
)