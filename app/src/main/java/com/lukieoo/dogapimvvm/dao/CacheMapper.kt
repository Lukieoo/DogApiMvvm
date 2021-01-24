package com.lukieoo.dogapimvvm.dao

import com.lukieoo.dogapimvvm.models.ImageDog
import com.lukieoo.dogapimvvm.utils.EntityMapper
import javax.inject.Inject


class CacheMapper
@Inject
constructor() :
    EntityMapper<DogCacheEntity, ImageDog> {

    override fun mapFromEntity(mailingsCacheEntity: DogCacheEntity): ImageDog {
        return ImageDog(
            message = mailingsCacheEntity.message,
            status = mailingsCacheEntity.status
        )
    }

    override fun mapToEntity(domainModel: ImageDog): DogCacheEntity {
        return DogCacheEntity(
            _id = "a",
            message = domainModel.message,
            status = domainModel.status
        )
    }

    fun mapFromEntityList(entities: List<DogCacheEntity>): List<ImageDog> {
        return entities.map { mapFromEntity(it) }
    }
}