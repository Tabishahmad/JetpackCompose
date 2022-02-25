package com.modlueinfotech.allwishesgif.composable

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.CircleCropTransformation
import com.funwithphotography.namephotooncake.util.AdUtils
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import com.modlueinfotech.allwishesgif.viewmodel.AppViewModel


@Composable
fun CategoryScreen(navController: NavController?, viewModel: AppViewModel, itemType : String) {
    Scaffold(
        bottomBar = { AppAdOnBottom(nativeBannerAd) },
        content = { categoryList(navController, viewModel , itemType)}
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun categoryList(navController: NavController?, viewModel: AppViewModel, itemType : String){
    val appData by viewModel.freeGamesFlow.collectAsState()
    println( " GET APP DATA " + appData)
    LazyVerticalGrid(cells = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ), content = {
            appData?.size?.let {
                items(it) { index ->
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp,
                    ) {
                        val singleNode = appData!![index]
                        // coil-compose
                        Image(
                            painter = rememberImagePainter(
                                data = singleNode.getCicon(),
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
                                    when (itemType) {
                                        "GIF", "IMAGES" -> {
                                            navController?.navigate(NavigationDestinations.imageNGifScreen + "/$index") {
                                            }
                                        }
                                        "QUOTES" -> {
                                            navController?.navigate(NavigationDestinations.quotesListScreen) {
                                            }
                                        }
                                    }
                                })
                        )
                    }
                }
            }
        })
}
