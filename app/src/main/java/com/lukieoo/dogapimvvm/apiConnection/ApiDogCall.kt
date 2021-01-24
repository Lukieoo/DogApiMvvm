package com.lukieoo.dogapimvvm.apiConnection

import com.lukieoo.dogapimvvm.models.ImageDog
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiDogCall {
    @GET("api/breeds/image/random/")
    fun getRandom():Flowable<ImageDog>
}