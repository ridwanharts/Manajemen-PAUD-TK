package com.wanstudio.manajemenpaudtk.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wanstudio.manajemenpaudtk.data.IntegerListConverter
import com.wanstudio.manajemenpaudtk.data.Student
import com.wanstudio.manajemenpaudtk.data.StringListConverter

@Database(entities = [Student::class], version = 1, exportSchema = true)
@TypeConverters(value = [StringListConverter::class, IntegerListConverter::class])
abstract class AppDatabase: RoomDatabase() {
}