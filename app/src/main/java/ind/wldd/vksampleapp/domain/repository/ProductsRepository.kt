package ind.wldd.vksampleapp.domain.repository

import arrow.core.Either
import ind.wldd.vksampleapp.domain.models.NetworkError
import ind.wldd.vksampleapp.domain.models.Product

interface ProductsRepository {

    suspend fun getProducts(
        page: Int,
        pageSize: Int
    ) : Either<NetworkError, List<Product>>

    suspend fun getProduct(
        id: Int
    ) : Either<NetworkError, Product?>
}