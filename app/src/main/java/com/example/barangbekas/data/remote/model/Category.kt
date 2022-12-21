package com.example.barangbekas.data.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    var id: String = "",
    var name: String = "",
    @SerializedName("image") var imageUrl: String = "",
    @SerializedName("icon") var iconUrl: String = "",
)
