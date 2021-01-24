package com.lukieoo.dogapimvvm.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DogCacheEntity::class ], version = 2)
abstract class DogDatabase: RoomDatabase() {

    abstract fun dogDao(): DogDao

    companion object{
        val DATABASE_NAME: String = "dog_db"
    }


}