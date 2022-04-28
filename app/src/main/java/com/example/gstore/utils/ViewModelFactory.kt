package com.example.gstore.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gstore.data.database.DbRoom
import com.example.gstore.data.repository.GlobalRepositoryUseCase
import com.example.gstore.ui.favourites.viewmodel.FavouritesViewModel
import com.example.gstore.ui.products.viewmodel.ProductDetailViewModel
import com.example.gstore.ui.products.viewmodel.ProductsViewModel

class ViewModelFactory(private val dbRoom: DbRoom): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when (modelClass) {
            ProductsViewModel::class.java -> ProductsViewModel(GlobalRepositoryUseCase(dbRoom)) as T
            ProductDetailViewModel::class.java -> ProductDetailViewModel(GlobalRepositoryUseCase(dbRoom)) as T
            FavouritesViewModel::class.java -> FavouritesViewModel(GlobalRepositoryUseCase(dbRoom)) as T
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}