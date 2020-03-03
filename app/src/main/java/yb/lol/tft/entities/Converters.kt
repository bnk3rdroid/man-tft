package yb.lol.tft.entities

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromRank(value: Rank?): String? {
        return if (value?.name?.length ?: 0 == 1) value?.name else "?"
    }

    @TypeConverter
    fun toRank(value: String?): Rank? {
        return when (value) {
            Rank.S.name -> Rank.S
            Rank.A.name -> Rank.A
            Rank.B.name -> Rank.B
            Rank.C.name -> Rank.C
            else -> Rank.UNKNOWN
        }
    }

}