package com.example.gstore.utils

import com.example.gstore.data.model.Product

interface Communicator {
    fun navigateToProductDetail(product: Product)
}