package com.example.gstore.ui.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gstore.data.model.Product
import com.example.gstore.data.repository.GlobalRepositoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val globalRepositoryUseCase: GlobalRepositoryUseCase) : ViewModel() {

    private val isFavourite = MutableLiveData<Boolean>()
    val currentIsFavourite: LiveData<Boolean>
        get() = isFavourite

    fun insertFavourite(product: Product){
        CoroutineScope(Dispatchers.IO).launch {
            globalRepositoryUseCase.insertFavourite(product)
        }
    }

    fun getIsFavourite(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val singleFavourite = globalRepositoryUseCase.isFavourite(id)
            isFavourite.postValue(singleFavourite)
        }
    }

    fun deleteFavourite(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            globalRepositoryUseCase.deleteFavourite(id)
        }
    }
}