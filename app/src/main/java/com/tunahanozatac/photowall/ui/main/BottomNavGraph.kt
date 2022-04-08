package com.tunahanozatac.photowall.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tunahanozatac.photowall.ui.screens.home.HomeScreen
import com.tunahanozatac.photowall.ui.screens.profilee.ProfileScreen
import com.tunahanozatac.photowall.ui.screens.settings.SettingsScreen

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}