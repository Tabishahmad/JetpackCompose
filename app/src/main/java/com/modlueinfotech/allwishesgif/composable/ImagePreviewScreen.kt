package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.AppUtilJava
import com.modlueinfotech.allwishesgif.utils.AppUtils
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import java.io.File

@Preview
@Composable
fun ImagePreviewScreen() {
    ImagePreviewScreen(null,"http://www.mediafire.com/file/35y84ita7fxvizv/g29.gif/file")
}

@Composable
fun ImagePreviewScreen(navController: NavController?,imgURL : String) {
    Scaffold(
        topBar = { TopBar() },
        content = { ImagePreviewScreenBody(navController,imgURL) },
        bottomBar = { AppAd(nativeBannerAd) }
    )
}

@Composable
fun ImagePreviewScreenBody(navController: NavController?,imgURL : String) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth().fillMaxHeight(.5f),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxHeight(fraction = 0.5f)
            ) {
                // coil-compose

                val painter = rememberImagePainter(data = imgURL,

                    builder = {
                        placeholder(R.drawable.loading)
                        error(R.drawable.error_img)
//                        transformations(
//
//                        )
                })
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.save),
                    modifier = Modifier
                        .weight(1f).height(90.dp)
                        .clickable {
                            saveItem(navController,context,imgURL,".jpg")
                        },
                    contentDescription = "Save",
                )
                Image(
                    painter = painterResource(id = R.drawable.setstatus),
                    modifier = Modifier
                        .weight(1f).height(90.dp)
                        .clickable {

                        },
                    contentDescription = "setstatus",
                )
                Image(
                    painter = painterResource(id = R.drawable.share),
                    modifier = Modifier
                        .weight(1f).height(90.dp)
                        .clickable {

                        },
                    contentDescription = "Name",
                )
            }
        }
    }
//    BackHandler() {
//        Toast.makeText(context,"BackHandler", Toast.LENGTH_LONG).show()
//    }
}
private fun saveItem(navController: NavController?,context:Context,ob: Any, extension: String) {
    AppUtilJava.getInstance().getFile(context, ob) { file ->
        val direct = File(
            context.getExternalFilesDir(null).toString() + "/Collection"
        )
        if (!direct.exists()) {
            direct.mkdirs()
        }
        val f = File(direct.absolutePath, "" + System.currentTimeMillis() + extension)
        file.copyTo(f)
    }
    navController?.navigate(NavigationDestinations.downloadAlertScreen)
}