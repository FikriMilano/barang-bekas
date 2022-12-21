package com.example.barangbekas.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.barangbekas.R
import com.example.barangbekas.data.remote.model.Product
import com.example.barangbekas.ui.component.Line
import com.example.barangbekas.helper.util.DummyUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    product: Product,
    onClickFAB: (Product) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { onClickFAB.invoke(product) },
            containerColor = colorResource(id = R.color.whatsapp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.whatsapp),
                tint = Color.White,
                contentDescription = "Back button",
            )
        }
    }) { paddingValues ->
        paddingValues // unused, forced by Compose library
        Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            ProductImage(product = product, onBackPressed = onBackPressed)
            ProductDetail(product = product)
        }
    }
}

@Composable
fun ProductImage(product: Product, onBackPressed: () -> Unit, modifier: Modifier = Modifier) {
    Box {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = modifier.requiredHeight(384.dp)
        )
//        Image(
//            painter = painterResource(id = R.drawable.laptop),
//            contentDescription = "Product image",
//            contentScale = ContentScale.FillHeight,
//            modifier = modifier.requiredHeight(384.dp)
//        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(128.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.black_t70),
                            colorResource(id = R.color.transparent)
                        )
                    )
                )
        )
        IconButton(onClick = onBackPressed, modifier.padding(top = 8.dp)) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                tint = Color.White,
                contentDescription = "Back button",
            )
        }
    }
}

@Composable
fun ProductDetail(product: Product, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(all = 16.dp)
    ) {
        Text(
            text = product.getPriceAsCurrency(),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyLarge,
        )
    }

    Line()

    Column(modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        Text(
            text = "Detail Product",
            style = MaterialTheme.typography.titleMedium,
        )
        Row(
            modifier = modifier.padding(top = 16.dp),
        ) {
            Text(
                text = "Category",
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier
                    .fillMaxWidth(0.5F)
                    .padding(end = 32.dp)
            )

            Text(
                text = (product.category?.name ?: "None").replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.End,
                modifier = modifier.fillMaxWidth(),
            )
        }

        Line(modifier = modifier.padding(top = 16.dp))

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(vertical = 16.dp)
        )
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    DetailScreen(
        product = DummyUtil.getProduct(),
        onClickFAB = {},
        onBackPressed = {}
    )
}