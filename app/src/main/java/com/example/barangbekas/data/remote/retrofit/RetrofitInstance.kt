package com.example.barangbekas.data.remote.retrofit

import com.example.barangbekas.data.remote.service.BarangBekasService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://barbek.masuk.id/api/"

    private val gson = GsonBuilder().setLenient().create()

    val instance: BarangBekasService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(BarangBekasService::class.java)
}