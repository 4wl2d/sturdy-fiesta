package ind.wldd.vksampleapp.presentation.screens.productsScreen.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import ind.wldd.vksampleapp.presentation.screens.productsScreen.components.ProductCard
import ind.wldd.vksampleapp.presentation.screens.productsScreen.models.ProductItem
import ind.wldd.vksampleapp.presentation.util.components.LoadingDialog

@Composable
internal fun ProductsScreen(
    products: LazyPagingItems<ProductItem>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = products.loadState) {
        if (products.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (products.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    ProductsContent(products = products)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductsContent(
    products: LazyPagingItems<ProductItem>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (products.loadState.refresh is LoadState.Loading) {
            LoadingDialog(isLoading = true)
        } else {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) { paddingValues ->
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalItemSpacing = 10.dp
                ) {
                    items(products) { product ->
                        ProductCard(product = product)
                    }
                    item {
                        if (products.loadState.append is LoadState.Loading) {
                            LoadingDialog(isLoading = true)
                        }
                    }
                }
            }
        }
    }
}

fun <T: Any> LazyStaggeredGridScope.items(
    items: LazyPagingItems<T>,
    key: ((T) -> Any)? = null,
    contentType: ((T) -> Any)? = null,
    itemContent: @Composable LazyStaggeredGridItemScope.(T) -> Unit
) {
    items(
        items.itemCount,
        key = items.itemKey(key),
        contentType = items.itemContentType(contentType)
    ) loop@{ i ->
        val item = items[i] ?: return@loop
        itemContent(item)
    }
}
