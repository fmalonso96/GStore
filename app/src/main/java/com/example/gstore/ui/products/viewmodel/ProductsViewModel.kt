package com.example.gstore.ui.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gstore.data.model.Product
import com.example.gstore.data.repository.GlobalRepositoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(private val globalRepositoryUseCase: GlobalRepositoryUseCase) : ViewModel() {

    private val products = MutableLiveData<List<Product>>()
    val currentProducts: LiveData<List<Product>>
        get() = products

    init {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                getRetrofitProducts()
            }
        }
    }

    private suspend fun getRetrofitProducts() {
        val productList = globalRepositoryUseCase.getRetrofitProducts()
        products.postValue(productList)
    }
}