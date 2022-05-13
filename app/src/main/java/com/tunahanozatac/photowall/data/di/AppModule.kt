package com.tunahanozatac.photowall.data.di

import com.tunahanozatac.photowall.data.remote.api.UnsplashApi
import com.tunahanozatac.photowall.data.repository.RandomRepository
import com.tunahanozatac.photowall.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCryptoRepository(
        api: UnsplashApi
    ) = RandomRepository(api)

    @Singleton
    @Provides
    fun provideCryptoApi(): UnsplashApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(UnsplashApi::class.java)
    }
}