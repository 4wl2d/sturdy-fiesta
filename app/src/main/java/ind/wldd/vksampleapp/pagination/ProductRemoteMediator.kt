package ind.wldd.vksampleapp.pagination

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ind.wldd.vksampleapp.data.remote.ProductsAPI
import ind.wldd.vksampleapp.domain.models.Product
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ProductRemoteMediator(
    private val productsAPI: ProductsAPI
): RemoteMediator<Int, Product>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Product>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        0
                    }
                    else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val products = productsAPI.getProducts(
                skip = loadKey,
                limit = state.config.pageSize
            )
            MediatorResult.Success(
                endOfPaginationReached = products.body()?.products!!.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}