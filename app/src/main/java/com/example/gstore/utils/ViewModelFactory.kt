package com.example.gstore.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gstore.data.repository.MainRepository
import com.example.gstore.ui.products.viewmodel.ProductsViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(MainRepository()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}