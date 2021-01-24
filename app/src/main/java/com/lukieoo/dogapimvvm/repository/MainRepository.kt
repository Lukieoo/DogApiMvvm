package com.lukieoo.dogapimvvm.repository

import com.lukieoo.dogapimvvm.apiConnection.ApiDogCall
import com.lukieoo.dogapimvvm.dao.CacheMapper
import com.lukieoo.dogapimvvm.dao.DogCacheEntity
import com.lukieoo.dogapimvvm.dao.DogDao
import com.lukieoo.dogapimvvm.models.ImageDog
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MainRepository
constructor(
    var dogDao: DogDao,
    private val apiDogCall: ApiDogCall,
    val cacheMapper: CacheMapper
) {

    fun fetchData() = apiDogCall.getRandom()

    fun geDog(): Observable<List<DogCacheEntity>> = dogDao.get()

    fun insertDog(imageDog: ImageDog) {
        dogDao.insert(cacheMapper.mapToEntity(imageDog))
    }
}