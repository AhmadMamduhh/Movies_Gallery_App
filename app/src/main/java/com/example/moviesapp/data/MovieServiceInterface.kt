package com.example.moviesapp.data

import com.example.moviesapp.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServiceInterface {
    @GET("/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

}