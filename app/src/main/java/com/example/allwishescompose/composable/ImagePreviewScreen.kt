package com.example.allwishescompose.composable

import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.CircleCropTransformation
import com.example.allwishescompose.R
import com.example.allwishescompose.utils.NavigationDestinations

@Preview
@Composable
fun ImagePreviewScreen() {
    ImagePreviewScreen("")
}

@Composable
fun ImagePreviewScreen(imgURL : String) {
    Scaffold(
        topBar = { TopBar() },
        content = { ImagePreviewScreenBody(imgURL) }
    )
}

@Composable
fun ImagePreviewScreenBody(imgURL : String) {
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
                    .align(Alignment.CenterHorizontally)
                    .fillMaxHeight(fraction = 0.5f)
            ) {
                // coil-compose
                val painter = rememberImagePainter(data = imgURL,

                    builder = {
                        placeholder(R.drawable.loading)
                        error(R.drawable.error_img)
                        transformations(
                            CircleCropTransformation()
                        )
                })
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gif),
                    modifier = Modifier
                        .weight(1f)
                        .clickable {

                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.images),
                    modifier = Modifier
                        .weight(1f)
                        .clickable {

                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.images),
                    modifier = Modifier
                        .weight(1f)
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