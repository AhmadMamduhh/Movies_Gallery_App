package com.example.moviesapp.repositries

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getPopularMovies(): LiveData<List<Movie>>{
        val mutableLiveData = MutableLiveData<List<Movie>>()

        if (popularMoviesList.size > 0) {
            mutableLiveData.postValue(popularMoviesList)
            return mutableLiveData

        } else {
            val retrofit = RetrofitClient.getRetrofitClient()
            val service = retrofit.create(MovieServiceInterface::class.java)

            service.getPopularMovies(Utils.apiKey).enqueue(
                object : Callback<MovieResponse> {
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("failure", t.message)
                    }

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            popularMoviesList.addAll(response.body()?.results!!)
                            mutableLiveData.postValue(popularMoviesList)

                        } else {
                            Log.d("failure", response.code().toString())

                        }

                    }

                }
            )

        }
        return mutableLiveData
    }

    fun getTopRated(): LiveData<List<Movie>>{
        val mutableLiveData = MutableLiveData<List<Movie>>()

        if(topRatedMoviesList.size > 0) {
            mutableLiveData.postValue(topRatedMoviesList)
            return mutableLiveData
        }
        else {


            val retrofit = RetrofitClient.getRetrofitClient()
            val service = retrofit.create(MovieServiceInterface::class.java)
            service.getTopRatedMovies(Utils.apiKey).enqueue(
                object : Callback<MovieResponse> {
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("failure", t.message)
                    }

                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            topRatedMoviesList.addAll(response.body()?.results!!)
                            mutableLiveData.postValue(topRatedMoviesList)

                        } else {
                            Log.d("failure", response.code().toString())
                        }

                    }

                }
            )
        }
        return mutableLiveData
    }
}
