package com.wanstudio.manajemenpaudtk.di

import androidx.room.Room
import com.wanstudio.manajemenpaudtk.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "manajemen_paudtk.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    //single { get<AppDatabase>().movieDao() }
}
