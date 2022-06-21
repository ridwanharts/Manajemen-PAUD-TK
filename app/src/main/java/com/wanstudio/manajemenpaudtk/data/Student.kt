package com.wanstudio.manajemenpaudtk.data


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Student(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val original_language: String? = null,
    val original_title: String? = null,
    val video: Boolean? = null,
    val genre_ids: List<Int>,
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val release_date: String? = null,
    val popularity: Double? = null,
    val vote_average: Float,
    val adult: Boolean? = null,
    val vote_count: Int? = null,
    var favourite: Boolean = false,
    var page: Int? = null
): Parcelable