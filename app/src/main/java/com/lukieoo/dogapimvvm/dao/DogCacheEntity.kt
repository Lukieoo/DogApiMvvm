package com.lukieoo.dogapimvvm.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs" )
class DogCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "_id")
    var _id: String,

    @ColumnInfo(name = "message")
    var message: String,

    @ColumnInfo(name = "status")
    var status: String,

)