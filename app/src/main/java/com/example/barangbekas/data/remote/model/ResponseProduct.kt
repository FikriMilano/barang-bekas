package com.example.barangbekas.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProduct(
    val status: Int = 0,
    val message: String = "",
    val query: String? = null,
    val category: String? = null,
    val data: List<Product>? = null
)
