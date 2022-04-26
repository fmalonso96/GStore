package com.example.gstore.data.repository

import com.example.gstore.data.api.APIService
import com.example.gstore.data.model.Product
import com.example.gstore.networking.Retrofit

class MainRepository {

    suspend fun getProducts(): List<Product> {
        return Retrofit.getRetrofit().create(APIService::class.java).callProducts()
    }
}