package com.example.moviesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.moviesapp.R
import com.example.moviesapp.data.MovieServiceInterface
import com.example.moviesapp.data.RetrofitClient
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.ui.MovieRecyclerViewAdapter
import com.example.moviesapp.util.Utils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Connecting with API
        val service = connectWithAPI()
        sendRequest(service)

    }


    private fun connectWithAPI() : MovieServiceInterface {
        val retrofit = RetrofitClient.getRetrofitClient()
        return retrofit.create(MovieServiceInterface::class.java)
    }

    private fun sendRequest(service : MovieServiceInterface) {
        service.getPopularMovies(Utils.apiKey).enqueue(
            object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("failure", t.message)
                    Toast.makeText(this@MainActivity,
                        "Something went wrong!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if(response.isSuccessful) {
                        popularRecyclerView.adapter = MovieRecyclerViewAdapter(
                            this@MainActivity, response.body()?.results!!)
                    }
                    else {
                        Log.d("failure", response.code().toString())
                        Toast.makeText(this@MainActivity,
                            "There was a problem in obtaining the movies!", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        )

        service.getTopRatedMovies(Utils.apiKey).enqueue(
            object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("failure", t.message)
                    Toast.makeText(this@MainActivity,
                        "Something went wrong!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if(response.isSuccessful) {
                        topRatedRecyclerView.adapter = MovieRecyclerViewAdapter(
                            this@MainActivity, response.body()?.results!!)
                    }
                    else {
                        Log.d("failure", response.code().toString())
                        Toast.makeText(this@MainActivity,
                            "There was a problem in obtaining the movies!", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        )
    }
}

