package com.example.barangbekas.ui.search.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.ui.component.ProductItem
import com.example.barangbekas.ui.component.SearchBarButtonWithBackButton
import com.example.barangbekas.helper.util.DummyUtil
import com.example.barangbekas.ui.component.StaggeredVerticalGrid

@Composable
fun SearchResultScreen(
    defaultQuery: String,
    onClickSearchBar: () -> Unit,
    products: List<Product>,
    onClickProduct: (Product) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        SearchBarButtonWithBackButton(
            defaultQuery = defaultQuery,
            onClickSearchBar = onClickSearchBar,
            onBackPressed = onBackPressed
        )

        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            products.forEachIndexed { index, product ->
//                if (index % 2 == 0) {
//                    // Render left side
//                    ProductItem(
//                        product = product,
//                        onClickProduct = onClickProduct,
//                        containerPadding = PaddingValues(bottom = 8.dp, end = 8.dp)
//                    )
//                } else {
                    // Render right side
                    ProductItem(
                        product = product,
                        onClickProduct = onClickProduct,
                        containerPadding = PaddingValues(4.dp)
                    )
//                }
            }
        }

//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(160.dp),
//            contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            items(products) { product ->
//                ProductItem(product = product, onClickProduct = { onClickProduct.invoke(product) })
//            }
//        }
    }
}

@Preview
@Composable
private fun SearchResultScreenPreview() {
    SearchResultScreen(
        defaultQuery = "Laptop",
        onClickSearchBar = {},
        products = DummyUtil.getProducts(),
        onClickProduct = {},
        onBackPressed = {}
    )
}