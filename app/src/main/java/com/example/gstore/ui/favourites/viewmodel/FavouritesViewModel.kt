package com.example.gstore.ui.favourites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gstore.data.model.Product
import com.example.gstore.data.repository.GlobalRepositoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavouritesViewModel(private val globalRepositoryUseCase: GlobalRepositoryUseCase) : ViewModel() {

    private val favouriteProducts = MutableLiveData<List<Product>>()
    val currentFavouriteProducts: LiveData<List<Product>>
        get() = favouriteProducts

    init {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                getFavouriteProducts()
            }
        }
    }

    private fun getFavouriteProducts() {
        val productList = globalRepositoryUseCase.getFavourites()
        favouriteProducts.postValue(productList)
    }
}