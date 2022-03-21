package com.tunahanozatac.photowall.data.network.repository

import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.data.network.api.UnsplashApi
import com.tunahanozatac.photowall.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RandomRepository @Inject constructor(
    private val api: UnsplashApi
) {
    suspend fun getRandom(clientId: String): Resource<RandomModel> {
        val response = try {
            api.getRandomImage(clientId)
        } catch (e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }
}