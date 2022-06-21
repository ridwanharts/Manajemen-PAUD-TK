package com.wanstudio.manajemenpaudtk.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter {
    @TypeConverter
    fun fromList(list: List<String>?): String{
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromString(value: String): List<String>{
        val listType = object: TypeToken<List<String>>(){}.type
        return Gson().fromJson(value, listType)
    }
}