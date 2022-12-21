package com.example.barangbekas.ui.search.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import com.example.barangbekas.ui.detail.DetailActivity
import com.example.barangbekas.ui.search.searchable.SearchActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SearchResultActivity : AppCompatActivity() {

    private val searchResultViewModel by viewModels<SearchResultViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val defaultQuery = intent.getStringExtra(QUERY_EXTRA) ?: ""
        searchResultViewModel.searchProducts(defaultQuery)
        setContent {
            val products =
                searchResultViewModel.productsState.collectAsState().value.data ?: listOf()
            MaterialTheme {
                SearchResultScreen(
                    defaultQuery = defaultQuery,
                    onClickSearchBar = {
                        val intent = Intent(this, SearchActivity::class.java)
                        intent.putExtra(QUERY_EXTRA, defaultQuery)
                        startActivity(intent)
                    },
                    products = products,
                    onClickProduct = { product ->
                        val intent = Intent(this, DetailActivity::class.java).apply {
                            putExtra(DetailActivity.PRODUCT_EXTRA, Json.encodeToString(product))
                        }
                        startActivity(intent)
                    },
                    onBackPressed = { onBackPressedDispatcher.onBackPressed() })
            }
        }
    }

    companion object {
        const val QUERY_EXTRA = "query_extra"
    }
}