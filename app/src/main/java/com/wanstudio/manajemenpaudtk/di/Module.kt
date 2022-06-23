package com.wanstudio.manajemenpaudtk.di

import androidx.room.Room
import com.wanstudio.manajemenpaudtk.database.AppDatabase
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "manajemen_paudtk.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    //single { get<AppDatabase>().movieDao() }
}

val viewModelModule = module {
//    single { MovieFragmentViewModel(get()) }
//    single { TvShowFragmentViewModel(get()) }
//    single { DetailViewModel(get()) }
//    single { FavoriteFragmentViewModel(get(), get())}
}

val repositoryModule = module{
//    single { MovieRepository(get(), get()) }
//    single { TvShowRepository(get(), get()) }
//    single { DetailRepository(get(), get()) }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl("https://")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    single { get<Retrofit>().create(CallInterface::class.java) }
//
//    single { CallHelperImpl(get()) }
}

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        val url = req.url
        val requestBuilder = req.newBuilder().url(
            url.newBuilder()
                .addQueryParameter("api_key", "BuildConfig.TMDB_API_KEY")
                .build()
        )
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}