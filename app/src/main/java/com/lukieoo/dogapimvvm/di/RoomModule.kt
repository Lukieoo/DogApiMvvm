package com.lukieoo.dogapimvvm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.lukieoo.dogapimvvm.dao.DogDao
import com.lukieoo.dogapimvvm.dao.DogDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object RoomModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMailingsDatabase(application: Application): DogDatabase {
        return Room
            .databaseBuilder(
                application.applicationContext,
                DogDatabase::class.java,
                DogDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideMailingsDao(dogDatabase: DogDatabase): DogDao {
        return dogDatabase.dogDao()
    }
}