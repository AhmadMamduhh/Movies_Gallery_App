package com.example.moviesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.models.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao() : MoviesDao

    companion object{
        private var INSTANCE : MoviesDatabase? = null

        fun getDatabase(context: Context): MoviesDatabase {
                if (INSTANCE != null)
                    return INSTANCE as MoviesDatabase

                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, MoviesDatabase::class.java,
                        "movies_db").allowMainThreadQueries().build()
                    return INSTANCE as MoviesDatabase
                }
        }
    }


}