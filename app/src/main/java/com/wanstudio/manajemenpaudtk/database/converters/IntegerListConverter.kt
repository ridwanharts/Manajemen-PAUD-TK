package com.wanstudio.manajemenpaudtk.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntegerListConverter {
    @TypeConverter
    fun fromList(list: List<Int>): String{
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    fun fromString(value: String): List<Int>?{
        val listType = object: TypeToken<List<Int>>(){}.type
        return Gson().fromJson<List<Int>>(value, listType)
    }
}