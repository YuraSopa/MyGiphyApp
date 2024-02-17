package com.example.mygiphyapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mygiphyapp.data.models.GiphyResponse


@Database(
    entities = [GiphyResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GiphyDatabase : RoomDatabase(){
    abstract fun getDao() : GiphyDao
}