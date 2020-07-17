package com.example.moviesapp.repositries

import com.example.moviesapp.models.Movie

interface MovieRepositryInterface {

    fun getPopularMovies(movieList:List<Movie>)
    fun getTopRatedMovies(movieList:List<Movie>)
}