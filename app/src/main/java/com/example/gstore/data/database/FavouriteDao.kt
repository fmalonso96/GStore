package com.example.gstore.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gstore.data.model.Product

@Dao
interface FavouriteDao {

    @Insert
    fun insertFavourite(favourite: FavouriteEntity): Long

    @Query("SELECT * FROM favourites_inventory ORDER BY id ASC ")
    fun getAllFavourites(): List<Product>

    @Query("SELECT * FROM favourites_inventory WHERE id = :id")
    fun isFavourite(id: Int): Boolean

    @Query("DELETE FROM favourites_inventory WHERE id = :id")
    fun deleteFavourite(id: Int)
}