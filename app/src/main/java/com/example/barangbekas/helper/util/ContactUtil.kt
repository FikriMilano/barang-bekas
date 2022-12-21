package com.example.barangbekas.helper.util

import com.example.barangbekas.data.remote.model.Product

object ContactUtil {

    fun getNumber(): String = "+6289504891606"

    fun buildMessage(product: Product): String = buildString {
        append("Saya tertarik dengan produk ini\n")
        append("${product.name}\n")
        append("${product.getPriceAsCurrency()}\n")
        append(product.imageUrl)
    }

    fun buildUrl(message: String, number: String = getNumber()): String = "https://api.whatsapp.com/send?phone=$number&text=$message"
}