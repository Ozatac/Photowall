package com.tunahanozatac.photowall.data.network.api

import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    //Random
    //https://api.unsplash.com/photos/random/?client_id=chB8NIWZMSLhYllkfAZYlT5CvW_3xK4w44uPcbaoN3E

    @GET("photos/random/")
    suspend fun getRandomImage(
        @Query("client_id") clientId: String
    ): RandomModel
}
