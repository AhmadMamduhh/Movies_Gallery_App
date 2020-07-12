package com.example.moviesapp.models

import com.google.gson.annotations.SerializedName

data class MovieResponse(var results : List<Movie>)

data class Movie(var title : String,
                 var overview: String,
                 @SerializedName("poster_path") var posterPath : String,
                 @SerializedName("release_date") var releaseDate : String,
                 @SerializedName("vote_average") var voteAverage : String)