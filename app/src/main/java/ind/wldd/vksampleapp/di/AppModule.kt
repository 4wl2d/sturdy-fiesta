package ind.wldd.vksampleapp.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ind.wldd.vksampleapp.data.remote.ProductsAPI
import ind.wldd.vksampleapp.domain.repository.ProductsRepository
import ind.wldd.vksampleapp.pagination.ProductRemoteMediator
import ind.wldd.vksampleapp.pagination.ProductsPagingSource
import ind.wldd.vksampleapp.util.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ProductsAPI {
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsPager(productsAPI: ProductsAPI, productsRepository: ProductsRepository)
    = Pager(
        config = PagingConfig(
            pageSize = Config.DEFAULT_PAGE_SIZE,
            enablePlaceholders = true
        ),
        remoteMediator = ProductRemoteMediator(productsAPI),
        pagingSourceFactory = { ProductsPagingSource(productsRepository) }
    )
}

