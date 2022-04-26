package com.example.gstore.data.api

import com.example.gstore.data.model.Product
import retrofit2.http.GET

interface APIService {
    @GET("products/")
    suspend fun callProducts(): List<Product>
}