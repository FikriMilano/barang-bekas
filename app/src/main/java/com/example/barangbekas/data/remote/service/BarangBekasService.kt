package com.example.barangbekas.data.remote.service

import com.example.barangbekas.data.remote.model.ResponseCategory
import com.example.barangbekas.data.remote.model.ResponseProduct
import retrofit2.http.GET
import retrofit2.http.Query

interface BarangBekasService {

    @GET("product")
    suspend fun getProducts(): ResponseProduct

    @GET("product")
    suspend fun getProductsByCategory(
        @Query("category") categoryId: String
    ): ResponseProduct

    @GET("product")
    suspend fun searchProducts(
        @Query("search") query: String
    ): ResponseProduct

    @GET("category")
    suspend fun getCategories(): ResponseCategory

    @GET("category")
    suspend fun getCategoryById(
        @Query("id") categoryId: String
    ): ResponseCategory
}