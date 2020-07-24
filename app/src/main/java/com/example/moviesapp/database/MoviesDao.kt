package com.example.moviesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.models.Movie

@Dao
interface MoviesDao {

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movie: Movie)

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table WHERE type = :type")
    fun getLocalPopularMovies(type : String? = "popular"): List<Movie>

    @Query("SELECT * FROM movies_table WHERE type = :type ORDER BY voteAverage DESC")
    fun getLocalTopRatedMovies(type : String? = "top_rated"): List<Movie>
}