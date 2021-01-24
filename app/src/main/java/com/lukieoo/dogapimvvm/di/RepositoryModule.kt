package com.lukieoo.dogapimvvm.di
import com.lukieoo.dogapimvvm.apiConnection.ApiDogCall
import com.lukieoo.dogapimvvm.dao.CacheMapper
import com.lukieoo.dogapimvvm.dao.DogDao
import com.lukieoo.dogapimvvm.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        dogDao: DogDao,
        apiClass: ApiDogCall,
        cacheMapper: CacheMapper,
    ): MainRepository {
        return MainRepository(dogDao, apiClass, cacheMapper)
    }
}