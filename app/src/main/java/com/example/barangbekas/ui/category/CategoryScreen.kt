package com.example.barangbekas.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.ui.component.ProductItem
import com.example.barangbekas.ui.component.SearchBarButtonWithBackButton
import com.example.barangbekas.helper.util.DummyUtil
import com.example.barangbekas.ui.component.CategoryImageItem
import com.example.barangbekas.ui.component.StaggeredVerticalGrid

@Composable
fun CategoryScreen(
    defaultQuery: String,
    onClickSearchBar: () -> Unit,
    category: Category,
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

        Column(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = category.name.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(bottom = 16.dp)
            )
            StaggeredVerticalGrid(
                maxColumnWidth = 220.dp,
                modifier = modifier.padding(bottom = 8.dp)
            ) {
                products.forEachIndexed { index, product ->
//                    if (index % 2 == 0) {
//                        // Render left side
//                        ProductItem(
//                            product = product,
//                            onClickProduct = onClickProduct,
//                            containerPadding = PaddingValues(bottom = 8.dp, end = 8.dp)
//                        )
//                    } else {
                        // Render right side
                        ProductItem(
                            product = product,
                            onClickProduct = onClickProduct,
                            containerPadding = PaddingValues(4.dp)
                        )
//                    }
                }
            }
        }

//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(160.dp),
//            contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            item(span = { GridItemSpan(2) }) {
//                Text(
//                    text = category.name,
//                    style = MaterialTheme.typography.headlineSmall,
//                    fontWeight = FontWeight.Bold,
//                )
//            }
//            items(products) { product ->
//                ProductItem(product = product, onClickProduct = { onClickProduct.invoke(product) })
//            }
//        }
    }
}

@Preview
@Composable
private fun CategoryScreenPreview() {
    val category = Category(name = "Laptop")
    CategoryScreen(
        defaultQuery = "Search product",
        onClickSearchBar = {},
        category = category,
        products = DummyUtil.getProducts(),
        onClickProduct = {},
        onBackPressed = {}
    )
}