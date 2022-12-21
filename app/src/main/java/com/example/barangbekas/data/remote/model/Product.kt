package com.example.barangbekas.data.remote.model

import com.example.barangbekas.helper.extension.asCurrency
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    @SerializedName("image") var imageUrl: String = "",
    var price: String = "",
    var stock: String = "",
    var weight: String = "",
    @SerializedName("category_id") var categoryId: String = "",
    var category: Category? = null,
) {
    fun getPriceAsCurrency(): String {
        return "Rp ${price.asCurrency()}"
    }
}
