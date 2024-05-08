package ind.wldd.vksampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import ind.wldd.vksampleapp.presentation.screens.productsScreen.screen.ProductsScreen
import ind.wldd.vksampleapp.presentation.screens.productsScreen.viewModel.ProductsViewModel
import ind.wldd.vksampleapp.presentation.ui.theme.VkSampleAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkSampleAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<ProductsViewModel>()
                    val products = viewModel.productsPagingFlow.collectAsLazyPagingItems()

                    ProductsScreen(products = products)
                }
            }
        }
    }
}