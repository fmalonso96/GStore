package com.example.gstore.data.model

import java.io.Serializable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product (
    val id: Int,
    val title: String,
    val description: String,
    val image: String
): Serializable