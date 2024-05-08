package ind.wldd.vksampleapp.presentation.screens.productsScreen.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    data: String,
    contentScale: ContentScale = ContentScale.Fit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        contentScale = contentScale,
        contentDescription = "Product image thumb",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    ProductImage(
        data = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
    )
}