package ind.wldd.vksampleapp.data.remote.models

data class ProductListResponse(
    val products: List<ProductResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
