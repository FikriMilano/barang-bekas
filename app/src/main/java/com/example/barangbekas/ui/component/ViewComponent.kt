package com.example.barangbekas.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.R
import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.helper.util.DummyUtil


@Composable
fun Line(modifier: Modifier = Modifier) {
    Divider(thickness = 1.dp, color = colorResource(R.color.black_t12), modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    product: Product,
    onClickProduct: (Product) -> Unit,
    modifier: Modifier = Modifier,
    containerPadding: PaddingValues = PaddingValues(),
) {
    Card(
        onClick = { onClickProduct.invoke(product) },
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.blue)),
        modifier = modifier.padding(containerPadding)
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = "Product Image",
                contentScale = ContentScale.Crop,
                modifier = modifier.height(128.dp)
            )
//            Image(
//                painter = painterResource(id = R.drawable.laptop),
//                contentDescription = "Product image",
//                contentScale = ContentScale.Crop
//            )
            Column(
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = product.name.replaceFirstChar { it.uppercase() },
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = product.getPriceAsCurrency(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(
        product = DummyUtil.getProduct(),
        onClickProduct = {}
    )
}

@Composable
fun CategoryItem(
    category: Category,
    onClickCategory: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilledTonalButton(
            onClick = { onClickCategory.invoke(category) },
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = colorResource(id = R.color.blue))
        ) {
            Box(
                modifier = modifier.padding(vertical = 8.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        // TODO: Use proper icons
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "CategoryItem"
                    )
                }
            }
        }
        Text(
            text = category.name.replaceFirstChar { it.uppercase() },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            modifier = modifier
                .widthIn(min = 32.dp, max = 64.dp)
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun CategoryImageItem(
    category: Category,
    onClickCategory: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
    FilledIconButton(
        onClick = { onClickCategory.invoke(category) },
        colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(id = R.color.blue_dark)),
        modifier = modifier.size(64.dp)
    ) {
//        Icon(
//            // TODO: Use proper icons
//            imageVector = Icons.Rounded.Star,
//            contentDescription = "CategoryItem",
//            modifier = modifier.size(36.dp)
//        )
        AsyncImage(
            model = category.iconUrl,
            contentDescription = "Category Icon",
            contentScale = ContentScale.Fit,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    val category = Category(
        id = "1",
        "Laptop",
        "https://images.tokopedia.net/img/KRMmCm/2022/5/9/488c5172-8305-4d76-8519-06c7ed915ba6.jpg"
    )
    CategoryImageItem(category, onClickCategory = {})
}

@Composable
fun SearchableBarWithBackButton(
    defaultQuery: String,
    onSearch: (String) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(TextFieldValue(defaultQuery)) }
    val focusRequester = remember { FocusRequester() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onBackPressed) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                tint = Color.Black,
                contentDescription = "Back button",
                modifier = modifier.padding(top = 8.dp)
            )
        }
        FilledTonalButton(
            onClick = { focusRequester.requestFocus() },
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = colorResource(id = R.color.blue)),
            modifier = modifier.padding(top = 8.dp, end = 16.dp)
        ) {
            BasicTextField(
                value = text,
                maxLines = 1,
                singleLine = true,
                onValueChange = { newText -> text = newText },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearch.invoke(text.text) }),
                decorationBox = { innerTextField ->
                    if (text.text.isEmpty()) {
                        Text(
                            text = "Search product",
                            color = colorResource(id = R.color.black_t70)
                        )
                    }
                    innerTextField.invoke()
                },
                modifier = modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            )
        }
    }
}

@Preview
@Composable
private fun SearchableBarWithBackButtonPreview() {
    SearchableBarWithBackButton(
        defaultQuery = "",
        onSearch = {},
        onBackPressed = {}
    )
}

@Composable
fun SearchBarButtonWithBackButton(
    defaultQuery: String,
    onClickSearchBar: () -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onBackPressed) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                tint = Color.Black,
                contentDescription = "Back button",
            )
        }
        SearchBarButton(
            defaultQuery = defaultQuery,
            onClickSearchBar = onClickSearchBar,
            modifier = modifier
        )
    }
}

@Composable
fun SearchBarButton(
    defaultQuery: String,
    onClickSearchBar: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FilledTonalButton(
        onClick = onClickSearchBar,
        colors = ButtonDefaults.filledTonalButtonColors(containerColor = colorResource(id = R.color.blue)),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon",
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = defaultQuery,
                style = MaterialTheme.typography.labelLarge,
                modifier = modifier.padding(top = 2.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBarButton(defaultQuery = "Search product", onClickSearchBar = {})
}
