package com.lukieoo.dogapimvvm.di

import android.content.Context
import androidx.room.Room
import com.lukieoo.dogapimvvm.dao.DogDao
import com.lukieoo.dogapimvvm.dao.DogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideMailingsDatabase(@ApplicationContext context: Context): DogDatabase {
        return Room
            .databaseBuilder(
                context,
                DogDatabase::class.java,
                DogDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMailingsDao(dogDatabase: DogDatabase): DogDao {
        return dogDatabase.dogDao()
    }
}