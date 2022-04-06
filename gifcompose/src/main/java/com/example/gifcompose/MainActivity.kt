package com.example.gifcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.gifcompose.ui.theme.AllWishesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllWishesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimatedGIF("http://www.mediafire.com/file/p8o5k5jf0qo69q9/g22.gif/file")
                }
            }
        }
    }
}

@Composable
fun AnimatedGIF(imageURL: String) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    val painter = rememberImagePainter(data = imageURL,
        imageLoader = imageLoader,
        builder = {
            placeholder(R.drawable.loading)
            error(R.drawable.error_img)
        })
    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp)),
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AllWishesComposeTheme {
        AnimatedGIF("http://www.mediafire.com/file/p8o5k5jf0qo69q9/g22.gif/file")
    }
}