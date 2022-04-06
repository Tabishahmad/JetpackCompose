package com.modlueinfotech.allwishesgif.composable

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import androidx.appcompat.app.AlertDialog
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.Coil
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.NavigationItem
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.AppUtilJava
import com.modlueinfotech.allwishesgif.utils.AppUtils
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import com.modlueinfotech.allwishesgif.utils.ShareUtils
import com.skydoves.landscapist.glide.GlideImage
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
    var isSaved = false

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight(.5f),
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
                if(!imgURL.startsWith("http")) {
                    isSaved = true
                }
                if(!isSaved) {
                    val imageLoader = ImageLoader.Builder(context)
                        .components {
                            if (Build.VERSION.SDK_INT >= 28) {
                                add(ImageDecoderDecoder.Factory())
                            } else {
                                add(GifDecoder.Factory())
                            }
                        }
                        .build()
                    val painter = rememberImagePainter(data = imgURL,
                          imageLoader = imageLoader,
                           builder = {
                            placeholder(R.drawable.loading)
                            error(R.drawable.error_img)
                        })
                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
//                    GlideImage(
//                        imageModel = imgURL,
//                        // Crop, Fit, Inside, FillHeight, FillWidth, None
//                        contentScale = ContentScale.Crop,
//                        // shows an image with a circular revealed animation.
//                        circularRevealedEnabled = true,
//                        // shows a placeholder ImageBitmap when loading.
//                        placeHolder = ImageBitmap.imageResource(R.drawable.loading),
//                        // shows an error ImageBitmap when the request failed.
//                        error = ImageBitmap.imageResource(R.drawable.error_img)
//                    )
                }else{
                    val bitmap = BitmapFactory.decodeFile(imgURL)
                    bitmap?.asImageBitmap()?.let {
                        Image(
                            bitmap = it,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .clickable(onClick = {
                                })
                        )
                    }
                }
            }
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                if(!isSaved) {
                    Image(
                        painter = painterResource(id = R.drawable.save),
                        modifier = Modifier
                            .weight(1f)
                            .height(90.dp)
                            .clickable {
                                saveItem(navController, context, imgURL, ".jpg")
                            },
                        contentDescription = "Save",
                    )
                }else{
                    Image(
                        painter = painterResource(id = R.drawable.delete),
                        modifier = Modifier
                            .weight(1f)
                            .height(90.dp)
                            .clickable {
                                delete(navController, imgURL, MainActivity.mainActivity)
                            },
                        contentDescription = "Save",
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.setstatus),
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clickable {
                            shareOnWhatsApp(context, imgURL, isSaved)
                        },
                    contentDescription = "setstatus",
                )
                Image(
                    painter = painterResource(id = R.drawable.share),
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clickable {
                            share(context, imgURL, isSaved)
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
fun share(context: Context,filePath: String,isSaved:Boolean) {
    if(!isSaved) {
        ShareUtils.shareGIF(context,filePath)
    }else {
        val path = filePath
        val file = File(path)
        val uri = ShareUtils.getProviderUri(context, file)
        ShareUtils.shareImage(context, uri, null)
    }
}

fun shareOnWhatsApp(context: Context,filePath: String,isSaved:Boolean) {
    if(!isSaved) {
        ShareUtils.shareGIFOnWhatsApp(context,filePath)
    }else {
        val path = filePath
        val file = File(path)
        val uri = ShareUtils.getProviderUri(context, file)
        ShareUtils.shareImage(context, uri, "com.whatsapp")
    }
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
private fun delete(navController: NavController?,filePath:String,activity: MainActivity) {
    val db = AlertDialog.Builder(activity)
    db.apply {
//            title = "Alert"
        setMessage("Do you want delete ?")
        setPositiveButton("Delete") { _, _ ->
            val f = File(filePath)
            if (f.exists()) {
                if (f.delete()) {
                    AppUtils.showMessage(activity, "Item Deleted")
                    navController?.navigate(NavigationDestinations.savedScreen) {
                        popUpTo(NavigationDestinations.savedScreen) {
                            inclusive = true
                        }
                    }
                }else{
                    AppUtils.showMessage(activity, "Failed to delete")
                }
            }else{
                AppUtils.showMessage(activity, "Item does not exist")
            }
        }
        setNegativeButton("Cancel") { _, _ ->

        }
    }
    val alertDialog = db.create()
    alertDialog.show()
}
