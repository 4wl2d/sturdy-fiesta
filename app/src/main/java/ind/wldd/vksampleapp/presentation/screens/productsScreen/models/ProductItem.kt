package ind.wldd.vksampleapp.presentation.screens.productsScreen.models

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import ind.wldd.vksampleapp.domain.models.Product
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class ProductItem(
    val id: Int,
    val price: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val images: List<String>,
    val rating: Double
): Parcelable

fun Product.toProductItem() =
    ProductItem(
        id = id,
        price = price,
        title = title,
        description = description,
        thumbnail = thumbnail,
        images = images,
        rating = rating
    )