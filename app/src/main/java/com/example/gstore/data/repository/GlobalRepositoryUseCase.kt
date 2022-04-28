package com.example.gstore.data.repository

import com.example.gstore.data.api.APIService
import com.example.gstore.data.database.DbRoom
import com.example.gstore.data.database.FavouriteEntity
import com.example.gstore.data.model.Product
import com.example.gstore.networking.Retrofit

class GlobalRepositoryUseCase(private val dbRoom: DbRoom): GlobalRepository.FavouritesRepository, GlobalRepository.Retrofit {

    override fun insertFavourite(product: Product): Long {
        val dbFavourite = FavouriteEntity(product.id, product.title, product.description, product.image)
        return dbRoom.favouriteDao.insertFavourite(dbFavourite)
    }

    override fun getFavourites(): List<Product> {
        return dbRoom.favouriteDao.getAllFavourites()
    }

    override fun isFavourite(id: Int): Boolean {
        return dbRoom.favouriteDao.isFavourite(id)
    }

    override fun deleteFavourite(id: Int) {
        dbRoom.favouriteDao.deleteFavourite(id)
    }

    override suspend fun getRetrofitProducts(): List<Product> {
        return Retrofit.getRetrofit().create(APIService::class.java).callProducts()
    }
}