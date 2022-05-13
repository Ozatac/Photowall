package com.tunahanozatac.photowall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.tunahanozatac.photowall.features.navigation.MainScreen
import com.tunahanozatac.photowall.features.theme.PhotoWallTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoWallTheme {
                MainScreen()
            }
        }
    }
}