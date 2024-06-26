package ind.wldd.vksampleapp.presentation.screens.productsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ind.wldd.vksampleapp.domain.models.Product
import ind.wldd.vksampleapp.presentation.screens.productsScreen.models.ProductItem
import ind.wldd.vksampleapp.presentation.screens.productsScreen.models.toProductItem
import ind.wldd.vksampleapp.presentation.ui.theme.GrayOnCard

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: ProductItem
) {
    Card(
        modifier = modifier
            .width(180.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = GrayOnCard)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White),
                contentAlignment = Alignment.BottomStart
            ) {
                ProductImage(data = product.thumbnail)
                Box(modifier = modifier.padding(start = 5.dp, bottom = 5.dp)) {
                    OnImageTransparentText(
                        text = product.rating.toString()
                    )
                }
            }
            Spacer(modifier = modifier.height(5.dp))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(text = product.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = modifier.height(2.dp))
                Text(text = product.description, color = Color.Gray, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = modifier.height(10.dp))
                OpenProductDetailsButton(text = product.price.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        product = Product(
            id = 1,
            title = "iPhone 9",
            description = "An apple mobile which is nothing like apple",
            price = 549,
            discountPercentage = 12.96,
            rating = 4.69,
            stock = 94,
            brand = "Apple",
            category = "smartphones",
            thumbnail= "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            images = listOf(
                "https://cdn.dummyjson.com/product-images/1/1.jpg",
                "https://cdn.dummyjson.com/product-images/1/2.jpg",
                "https://cdn.dummyjson.com/product-images/1/3.jpg"
            )
        ).toProductItem()
    )
}