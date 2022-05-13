package com.tunahanozatac.photowall.data.repository

import com.tunahanozatac.photowall.data.model.photos.PhotosList
import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.data.remote.api.UnsplashApi
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

    suspend fun getPhotosList(clientId: String): Resource<PhotosList> {
        val response = try {
            api.getPhotosList(clientId)
        } catch (e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }
}