package ind.wldd.vksampleapp.data.remote

import ind.wldd.vksampleapp.data.remote.models.ProductListResponse
import ind.wldd.vksampleapp.data.remote.models.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductsAPI {
    @GET("/products")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int,
    ): Response<ProductListResponse>

    @GET("/product/{id}")
    suspend fun getProduct(
        @Path("id") id: Int,
    ): Response<ProductResponse>
}