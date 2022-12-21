package com.example.barangbekas.ui.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.ui.detail.DetailActivity
import com.example.barangbekas.ui.search.searchable.SearchActivity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CategoryActivity : AppCompatActivity() {

    private val categoryViewModel by viewModels<CategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val categoryJson = intent.getStringExtra(CATEGORY_EXTRA) ?: ""
        val category = Json.decodeFromString<Category>(categoryJson)
        categoryViewModel.getProductsByCategory(category.id)
        setContent {
            val products = categoryViewModel.productsState.collectAsState().value.data ?: listOf()

            MaterialTheme {
                CategoryScreen(
                    defaultQuery = "Search product",
                    onClickSearchBar = {
                        val intent = Intent(this, SearchActivity::class.java)
                        startActivity(intent)
                    },
                    category = category,
                    products = products,
                    onClickProduct = { product ->
                        val intent = Intent(this, DetailActivity::class.java).apply {
                            putExtra(DetailActivity.PRODUCT_EXTRA, Json.encodeToString(product))
                        }
                        startActivity(intent)
                    },
                    onBackPressed = { onBackPressedDispatcher.onBackPressed() }
                )
            }
        }
    }

    companion object {
        const val CATEGORY_EXTRA = "category_extra"
    }
}