package com.example.barangbekas.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCategory(
    val status: Int = 0,
    val message: String = "",
    val data: List<Category> = listOf()
)
