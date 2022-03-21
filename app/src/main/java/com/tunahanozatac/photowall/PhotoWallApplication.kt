package com.tunahanozatac.photowall

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotoWallApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}