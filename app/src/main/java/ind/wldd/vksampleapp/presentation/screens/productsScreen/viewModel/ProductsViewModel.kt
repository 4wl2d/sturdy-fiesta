package ind.wldd.vksampleapp.presentation.screens.productsScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import ind.wldd.vksampleapp.domain.models.Product
import ind.wldd.vksampleapp.presentation.screens.productsScreen.models.toProductItem
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    pager: Pager<Int, Product>
) : ViewModel() {

    val productsPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map {
                it.toProductItem()
            }
        }
        .cachedIn(viewModelScope)
}
