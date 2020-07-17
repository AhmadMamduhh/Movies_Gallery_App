package com.example.moviesapp.repositries

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.moviesapp.data.MovieServiceInterface
import com.example.moviesapp.data.RetrofitClient
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.ui.MovieRecyclerViewAdapter
import com.example.moviesapp.util.Utils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepositry {

    var popularMoviesList: MutableList<Movie> = mutableListOf()
    var topRatedMoviesList: MutableList<Movie> = mutableListOf()

    fun getPopularMovies(
        movieRepositryInterface: MovieRepositryInterface,
        context: Context
    ) {

        if (popularMoviesList.size > 0) {
             movieRepositryInterface.getPopularMovies(popularMoviesList)

        } else {
            val retrofit = RetrofitClient.getRetrofitClient()
            val service = retrofit.create(MovieServiceInterface::class.java)

            service.getPopularMovies(Utils.apiKey).enqueue(
                object : Callback<MovieResponse> {
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("failure", t.message)
                        Toast.makeText(
                            context,
                            "Something went wrong!", Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            popularMoviesList.addAll(response.body()?.results!!)
                            movieRepositryInterface.getPopularMovies(popularMoviesList)

                        } else {
                            Log.d("failure", response.code().toString())
                            Toast.makeText(
                                context,
                                "There was a problem in obtaining the movies!", Toast.LENGTH_SHORT
                            ).show()
                        }

                    }

                }
            )

        }
    }

    fun getTopRated(movieRepositryInterface: MovieRepositryInterface, context: Context) {

        if(topRatedMoviesList.size > 0) {
            movieRepositryInterface.getTopRatedMovies(topRatedMoviesList)
        }
        else {


            val retrofit = RetrofitClient.getRetrofitClient()
            val service = retrofit.create(MovieServiceInterface::class.java)
            service.getTopRatedMovies(Utils.apiKey).enqueue(
                object : Callback<MovieResponse> {
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("failure", t.message)
                        Toast.makeText(
                            context,
                            "Something went wrong!", Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            topRatedMoviesList.addAll(response.body()?.results!!)
                            movieRepositryInterface.getTopRatedMovies(topRatedMoviesList)

                        } else {
                            Log.d("failure", response.code().toString())
                            Toast.makeText(
                                context,
                                "There was a problem in obtaining the movies!", Toast.LENGTH_SHORT
                            ).show()
                        }

                    }

                }
            )
        }
    }
}
