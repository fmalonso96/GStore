package com.example.gstore.data.repository

import com.example.gstore.data.model.Product

interface GlobalRepository {

    interface FavouritesRepository {
        fun insertFavourite(product: Product): Long
        fun getFavourites(): List<Product>
        fun isFavourite(id: Int): Boolean
        fun deleteFavourite(id: Int)
    }

    interface Retrofit {
        suspend fun getRetrofitProducts(): List<Product>
    }
}