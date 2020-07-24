package com.example.moviesapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(var results: List<Movie>)

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var overview: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: String,
    var type : String? = null
)
