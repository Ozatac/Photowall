package com.tunahanozatac.photowall.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.data.network.viewmodel.RandomViewModel
import com.tunahanozatac.photowall.util.Constants.API_KEY
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RandomViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = "getData") {
        viewModel.loadRandomPhoto(API_KEY)
    }

    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            CryptoList(navController = navController)
        }
    }
}

@Composable
fun CryptoList(
    navController: NavController,
    viewModel: RandomViewModel = hiltViewModel()
) {
    val cryptoList by remember { viewModel.cryptoList }
    val isLoading by remember { viewModel.isLoading }

    CryptoListView(cryptos = cryptoList, navController = navController)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
    }

}

@Composable
fun CryptoListView(cryptos: List<RandomModel>, navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(navController = navController, crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(navController: NavController, crypto: RandomModel) {
    Box {}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.secondary)

    ) {
        Text(
            text = crypto.user.first_name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
    }
}

/*@Composable  //SwipeRefreshCompose compose calismasi deneme
fun SwipeRefreshCompose() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        var refreshing by remember { mutableStateOf(false) }
        LaunchedEffect(refreshing) {
            if (refreshing) {
                delay(2000)
                refreshing = false
            }
        }

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = refreshing),
            onRefresh = { refreshing = true }
        ) {
            LazyColumn {

            }
        }
    }
}*/
