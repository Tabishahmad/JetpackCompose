package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.CircleCropTransformation
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import com.modlueinfotech.allwishesgif.viewmodel.AppViewModel
import java.io.File
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun SavedScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { AppAd(nativeBannerAd) },
        content = { padding-> androidx.compose.foundation.layout.Column(
                            modifier = Modifier.padding(padding)
                ){ SavedScreenContent(navController)}}
    )
    BackHandler() {
        navController?.navigate(NavigationDestinations.mainScreen)
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SavedScreenContent(navController: NavController?) {
    val appData = getCollection(LocalContext.current)

    LazyStaggeredGrid(cells = StaggeredCells.Adaptive(128.dp),
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
                        val filePath =  appData?.get(index)
                        println("filePath " + filePath)
                        // coil-compose
                        val bitmap = BitmapFactory.decodeFile(filePath)
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable(onClick = {
                                    val encodedUrl = URLEncoder.encode(filePath, StandardCharsets.UTF_8.toString())
                                    navController?.navigate(NavigationDestinations.imgPrevScreen + "/$encodedUrl")
                                })
                        )
                    }
                }
            }
        })
}
private fun getCollection(context: Context): List<String> {
    val list = ArrayList<String>()
    val file = File(context.getExternalFilesDir(null).toString() + "/Collection")
    if (file.exists()) {
        file.listFiles().forEach {
            list.add(it.path)
        }
    }
    return list.reversed()
}