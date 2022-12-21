package com.example.barangbekas.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.colorResource
import com.example.barangbekas.R
import com.example.barangbekas.ui.category.CategoryActivity
import com.example.barangbekas.ui.detail.DetailActivity
import com.example.barangbekas.ui.search.searchable.SearchActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class HomeActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getCategories()
        homeViewModel.getProducts()
        setContent {
            val categories = homeViewModel.categoriesState.collectAsState().value.data
            val products = homeViewModel.productsState.collectAsState().value.data ?: listOf()
            MaterialTheme {
                HomeScreen(
                    defaultQuery = "Search product",
                    onClickSearchBar = {
                        val intent = Intent(this, SearchActivity::class.java)
                        startActivity(intent)
                    },
                    categories = categories,
                    onClickCategory = { category ->
                        val intent = Intent(this, CategoryActivity::class.java).apply {
                            putExtra(CategoryActivity.CATEGORY_EXTRA, Json.encodeToString(category))
                        }
                        startActivity(intent)
                    },
                    products = products,
                    onClickProduct = { product ->
                        val intent = Intent(this, DetailActivity::class.java).apply {
                            putExtra(DetailActivity.PRODUCT_EXTRA, Json.encodeToString(product))
                        }
                        startActivity(intent)
                    }
                )
            }
        }
    }
}