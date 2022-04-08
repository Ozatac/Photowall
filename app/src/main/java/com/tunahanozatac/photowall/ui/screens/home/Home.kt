package com.tunahanozatac.photowall.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.util.Constants.API_KEY

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RandomViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = "getData") {
        viewModel.loadRandomPhoto(API_KEY)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column {
            CryptoList()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CryptoList(
    viewModel: RandomViewModel = hiltViewModel()
) {
    val cryptoList by remember { viewModel.cryptoList }
    val isLoading by remember { viewModel.isLoading }

    CryptoListView(cryptos = cryptoList)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CryptoListView(cryptos: List<RandomModel>) {
    /*LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("My Books")
                LazyRow {
                    items(cryptos) {
                        CryptoRow(cryptos = cryptos)
                    }
                }
            }
        }
        item {
            Text("Whishlisted Books", style = MaterialTheme.typography.h4)
        }
        items(cryptos.windowed(2, 2, true)) { item ->
            Row {
                Image(
                    painter = rememberImagePainter(data = cryptos[0].user.profile_image.large),
                    contentDescription = cryptos[0].user.name,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(160.dp, 160.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .border(2.dp, Color.Gray, shape = RoundedCornerShape(50.dp))
                )
                Image(
                    painter = rememberImagePainter(data = cryptos[0].user.profile_image.large),
                    contentDescription = cryptos[0].user.name,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(170.dp, 180.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .border(2.dp, Color.Gray, shape = RoundedCornerShape(50.dp))
                )
            }
        }
    }*/
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                Text(
                    text = "Recent List",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            //Horizontal Scroll view
            item {
                LazyRow {
                    items(cryptos.size) {
                        Card(
                            modifier = Modifier
                                .width(110.dp)
                                .height(120.dp)
                                .padding(10.dp, 5.dp, 5.dp, 0.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White),
                            elevation = 5.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(5.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = rememberImagePainter(data = cryptos[0].user.profile_image.large),
                                    contentDescription = "profile Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    text = "Test",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Lists",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }

            items(cryptos.size) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(10.dp, 5.dp, 10.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    elevation = 5.dp
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberImagePainter(data = cryptos[0].user.profile_image.large),
                                contentDescription = "Profile Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.padding(5.dp))

                            Column {
                                Text(
                                    text = "Sample Test",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(2.dp))

                                Text(
                                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun CryptoRow(cryptos: List<RandomModel>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = rememberImagePainter(data = cryptos[0].user.profile_image.medium),
            contentDescription = cryptos[0].user.name,
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp, 80.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
}
