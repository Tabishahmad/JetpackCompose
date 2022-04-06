package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.*
import com.mopub.common.util.ImageUtils
import java.io.File

@Preview
@Composable
fun QuotesPreviewScreen(){
    QuotesPreviewScreenBody(quote = "Quotes", position = 0)
}

@Composable
fun QuotesPreviewScreen(quote: String,position: Int?) {
    Scaffold(
        topBar = { TopBar() },
        content = { QuotesPreviewScreenBody(quote,position) },
        bottomBar = { AppAd(nativeBannerAd) }
    )
}
var jetCaptureView: MutableState<ProfileCardView>? = null
@Composable
fun QuotesPreviewScreenBody(quote : String,position: Int?) {
    println("QuotesPreviewScreenBody "+position)
    jetCaptureView = remember { mutableStateOf(ProfileCardView(MainActivity.mainActivity)) }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Box {
//            Card(
//                modifier = Modifier
//                    .padding(horizontal = 8.dp, vertical = 8.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight(.5f),
//                elevation = 2.dp,
//                backgroundColor = Color(colorArray[position!!%5]),
//                shape = RoundedCornerShape(corner = CornerSize(16.dp))
//            ) {
//                Row {
//                    Column(
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .fillMaxWidth()
//                            .align(Alignment.CenterVertically)
//                    ) {
//                        Text(text = quote, style = MaterialTheme.typography.h6)
//                    }
//                }
//            }
            ProfileUI(quote,position)
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.save),
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clickable {

                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.setstatus),
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clickable {

                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.share),
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clickable {
                            jetCaptureView?.value?.capture(jetCaptureView?.value as ProfileCardView)
//                            shareImage(this@Box as View)
                        },
                    contentDescription = "Name",
                )
            }
        }
    }
}

private fun saveItem(navController: NavController?, context: Context, ob: Any, extension: String) {
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
private fun shareImage(v: View) {
    val bm: Bitmap? = AppUtilJava.getInstance().captureScreen(v)
    bm?.let {
//            val uri: Uri? = AppUtils.getInstance().getLocalBitmapUri(this, bm)
//        AppUtils.getInstance().shareBitmap(requireContext(), bm, false)
    }
}
@Composable
private fun ProfileUI(quote1 : String,position: Int?) {
    AndroidView(modifier = Modifier.wrapContentSize(),
        factory = {
            ProfileCardView(it).apply {
                post {
                    jetCaptureView?.value = this
                    title = quote1
                    if (position != null) {
                        colorIndex = position
                    }
                }
            }
        }
    )
}
