package com.example.barangbekas.helper.extension

import java.text.NumberFormat

fun Int.asCurrency(): String {
    val groupedNumber = NumberFormat.getInstance().format(this)
    return groupedNumber.replace(",", ".")
}

fun String.asCurrency(): String {
    return this.toInt().asCurrency()
}