package com.example.barangbekas

import com.example.barangbekas.helper.extension.asCurrency
import org.junit.Test

import org.junit.Assert.*
import java.text.DecimalFormat
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun number_format() {
        val number = "30000".asCurrency()
        println(number)
    }
}