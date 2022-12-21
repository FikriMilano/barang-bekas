package com.example.barangbekas.ui.search.searchable

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.tooling.preview.Preview
import com.example.barangbekas.ui.component.SearchableBarWithBackButton

@Composable
fun SearchScreen(
    defaultQuery: String,
    onSearch: (String) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        SearchableBarWithBackButton(
            defaultQuery = defaultQuery,
            onSearch = onSearch,
            onBackPressed = onBackPressed,
        )
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
}