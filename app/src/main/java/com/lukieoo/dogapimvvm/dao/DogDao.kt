package com.lukieoo.dogapimvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable

@Dao
interface  DogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(dogEntity: DogCacheEntity)

    @Query("SELECT * FROM dogs")
     fun get(): Observable<List<DogCacheEntity>>
}