package com.tunahanozatac.photowall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.tunahanozatac.photowall.ui.main.MainScreen
import com.tunahanozatac.photowall.ui.theme.PhotoWallTheme
import dagger.hilt.android.AndroidEntryPoint

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