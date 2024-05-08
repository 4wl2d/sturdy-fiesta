package ind.wldd.vksampleapp.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ind.wldd.vksampleapp.domain.models.Product
import ind.wldd.vksampleapp.domain.repository.ProductsRepository
import ind.wldd.vksampleapp.util.Config

class ProductsPagingSource(
    private val productsRepository: ProductsRepository
): PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params : LoadParams<Int>) : LoadResult<Int, Product> {
        return try {
            val page = params.key ?: 0
            val pageSize = params.loadSize.coerceAtMost(Config.DEFAULT_PAGE_SIZE)

            var response = productsRepository.getProducts(
                page,
                pageSize
            ).getOrNull()

            if (response.isNullOrEmpty()) {
                response = listOf()
            }

            val prevKey = if (page == 0) null else page - 1
            val nextKey = if (response.size < pageSize) null else page + 1

            LoadResult.Page(
                data = response,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e : Exception) {
            LoadResult.Error(e)
        }
    }
}