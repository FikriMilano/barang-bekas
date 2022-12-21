package com.example.barangbekas.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.helper.util.DummyUtil
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.ui.component.CategoryImageItem
import com.example.barangbekas.ui.component.ProductItem
import com.example.barangbekas.ui.component.SearchBarButton
import com.example.barangbekas.ui.component.StaggeredVerticalGrid

@Composable
fun HomeScreen(
    defaultQuery: String,
    onClickSearchBar: () -> Unit,
    categories: List<Category>,
    onClickCategory: (Category) -> Unit,
    products: List<Product>,
    onClickProduct: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    return Column {
        SearchBarButton(
            defaultQuery = defaultQuery,
            onClickSearchBar = onClickSearchBar,
            modifier = modifier
        )

        Column(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                .verticalScroll(rememberScrollState())
        ) {
            LazyRow(
                contentPadding = PaddingValues(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryImageItem(
                        category = category,
                        onClickCategory = onClickCategory
                    )
                }
            }
            StaggeredVerticalGrid(
                maxColumnWidth = 220.dp,
                modifier = modifier.padding(bottom = 8.dp),
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
//                        // Render right side
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
//            contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
//            item(span = { GridItemSpan(2) }) {
//                LazyRow(
//                    contentPadding = PaddingValues(horizontal = 16.dp),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    items(categories) { category ->
//                        CategoryImageItem(
//                            category = category,
//                            onClickCategory = onClickCategory
//                        )
//                    }
//                }
//            }
//            itemsIndexed(products) { index, product ->
//                if (index % 2 == 0) {
//                    // Render left side
//                    ProductItem(
//                        product = product,
//                        onClickProduct = onClickProduct,
//                        containerPadding = PaddingValues(horizontal = 16.dp)
//                    )
//                } else {
//                    // Render right side
//                    ProductItem(
//                        product = product,
//                        onClickProduct = onClickProduct,
//                        containerPadding = PaddingValues(end = 16.dp)
//                    )
//                }
//            }
//        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val categories = DummyUtil.getCategories()
    val products = DummyUtil.getProducts()
    HomeScreen("Search product", {}, categories, {}, products, {})
}