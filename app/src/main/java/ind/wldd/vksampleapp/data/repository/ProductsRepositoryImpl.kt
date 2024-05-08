package ind.wldd.vksampleapp.data.repository

import arrow.core.Either
import ind.wldd.vksampleapp.data.mapper.toNetworkError
import ind.wldd.vksampleapp.data.remote.ProductsAPI
import ind.wldd.vksampleapp.data.remote.models.toProduct
import ind.wldd.vksampleapp.domain.models.NetworkError
import ind.wldd.vksampleapp.domain.models.Product
import ind.wldd.vksampleapp.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsAPI
): ProductsRepository {
    override suspend fun getProducts(
        page: Int,
        pageSize: Int
    ): Either<NetworkError, List<Product>> = Either.catch {
        val skip = page * pageSize
        val result: List<Product>
        val response = productsApi.getProducts(
            skip = skip,
            limit = pageSize
        )
        result = if (response.isSuccessful) {
            response.body()?.products!!.map { it.toProduct() } // !! -> плохая тема
        } else {
            emptyList()
        }
        result
    }.mapLeft { it.toNetworkError() }


    override suspend fun getProduct(
        id: Int
    ): Either<NetworkError, Product?> = Either.catch {
        val response = productsApi.getProduct(
            id = id
        )
        val result = if (response.isSuccessful) {
            response.body()?.toProduct()
        } else {
            null
        }
        result
    }.mapLeft { it.toNetworkError() }
}