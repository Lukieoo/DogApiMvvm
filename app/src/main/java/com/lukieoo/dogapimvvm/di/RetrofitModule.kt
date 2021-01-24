package com.lukieoo.dogapimvvm.di

import com.lukieoo.dogapimvvm.apiConnection.ApiDogCall
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object  RetrofitModule {

    private const val BASE_URL = "https://dog.ceo/"

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    }
    @JvmStatic
    @Singleton
    @Provides
    fun providesApiClass(retrofit:  Retrofit.Builder):ApiDogCall{
        return  retrofit
            .build()
            .create(ApiDogCall::class.java)
    }


}