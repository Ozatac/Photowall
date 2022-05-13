package com.tunahanozatac.photowall.features.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.tunahanozatac.photowall.data.model.photos.PhotosList
import com.tunahanozatac.photowall.util.Constants.API_KEY
import androidx.compose.foundation.layout.Box as Box1

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RandomViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = "getData") {
        viewModel.getPhotosList(API_KEY)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
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
    val cryptoList by remember { viewModel.photosList }
    val isLoading by remember { viewModel.isLoading }

    CryptoListView(cryptos = cryptoList)

    Box1(
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
fun CryptoListView(cryptos: List<PhotosList?>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
            item {
                LazyRow {
                    itemsIndexed(cryptos) { index, item ->
                        Column(
                            modifier = Modifier.padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = rememberImagePainter(data = item?.get(index)?.urls?.full),
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
            item {
                Text(
                    text = "Lists",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            items(items = cryptos) { ssss ->
                val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2)
                FlowRow(
                    mainAxisSize = SizeMode.Expand,
                    mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween
                ) {
                    for (i in ssss?.indices!!) {
                        Card(
                            modifier = Modifier
                                .size(itemSize)
                                .padding(10.dp, 5.dp, 5.dp, 5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(Color.White),
                            elevation = 5.dp
                        ) {
                            Image(
                                painter = rememberImagePainter(data = ssss[i]?.urls?.full),
                                contentDescription = "Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                        }
                    }
                }
            }
        }
    }
}