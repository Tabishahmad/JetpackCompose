package com.example.allwishescompose.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.CircleCropTransformation
import com.example.allwishescompose.MainActivity
import com.example.allwishescompose.R
import com.example.allwishescompose.utils.NavigationDestinations
import com.example.allwishescompose.viewmodel.AppViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageNGIFScreen(navController: NavController?,
                    position:Int?,
                    viewModel: AppViewModel
) {
    val appData by viewModel.freeGamesFlow.collectAsState()
    LazyVerticalGrid(cells = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ), content = {
            appData?.get(position!!)?.getImage()?.size?.let {
                items(it) { index ->
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp,
                    ) {
                        val imageURL = appData?.get(position)?.getImage()!!.get(index)?.imageurl
                        println("imageURL " + imageURL)
                        // coil-compose
                        Image(
                            painter = rememberImagePainter(
                                data = imageURL,
                                onExecute = ImagePainter.ExecuteCallback { _, _ -> true },
                                builder = {
                                    crossfade(true)
                                    placeholder(R.drawable.gif)
                                    size(OriginalSize)
                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable(onClick = {
                                    val encodedUrl = URLEncoder.encode(imageURL, StandardCharsets.UTF_8.toString())
                                    navController?.navigate(NavigationDestinations.imgPrevScreen+"/$encodedUrl")
                                })
                        )
                    }
                }
            }
        })
}