package com.example.mygiphyapp.di

import android.app.Application
import androidx.room.Room
import com.example.mygiphyapp.data.GiphyDatabase
import com.example.mygiphyapp.data.api.GiphyAPI
import com.example.mygiphyapp.other.Constants.GIPHY_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGiphyDatabase(
        @ApplicationContext app: Application
    ) = Room.databaseBuilder(
        app,
        GiphyDatabase::class.java,
        GIPHY_DB_NAME
    )

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/gifs/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGiphyApi(retrofit: Retrofit): GiphyAPI {
        return retrofit.create(GiphyAPI::class.java)
    }
}