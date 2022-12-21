package com.example.barangbekas.ui.search.searchable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.barangbekas.ui.detail.DetailActivity
import com.example.barangbekas.ui.search.result.SearchResultActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val defaultQuery = intent.getStringExtra(QUERY_EXTRA) ?: ""
        setContent {
            MaterialTheme {
                SearchScreen(
                    defaultQuery = defaultQuery,
                    onSearch = { query ->
                        val intent = Intent(this, SearchResultActivity::class.java).apply {
                            putExtra(SearchResultActivity.QUERY_EXTRA, query.trim())
                        }
                        startActivity(intent)
                        finish()
                    },
                    onBackPressed = { onBackPressedDispatcher.onBackPressed() }
                )
            }
        }
    }

    companion object {
        const val QUERY_EXTRA = "query_extra"
    }
}