package com.example.barangbekas.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.helper.util.ContactUtil
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonProduct = intent.getStringExtra(PRODUCT_EXTRA) ?: ""
        val product = Json.decodeFromString<Product>(jsonProduct)
        viewModel.getCategoryById(product.categoryId)
        setContent {
            product.category = viewModel.categoryState.collectAsState().value
            MaterialTheme {
                DetailScreen(
                    product = product,
                    onClickFAB = { product ->
                        val message = ContactUtil.buildMessage(product)
                        val url = ContactUtil.buildUrl(message)
                        onClickContactButton(url)
                    },
                    onBackPressed = { onBackPressedDispatcher.onBackPressed() }
                )
            }
        }
    }

    private fun onClickContactButton(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    companion object {
        const val PRODUCT_EXTRA = "product_extra"
    }
}