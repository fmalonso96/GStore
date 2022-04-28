package com.example.gstore.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites_inventory")
data class FavouriteEntity(

    @PrimaryKey()
    var id: Int?,

    @ColumnInfo()
    var title: String,

    @ColumnInfo()
    var description: String,

    @ColumnInfo()
    var image: String
)
