package com.modlueinfotech.allwishesgif.composable

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modlueinfotech.allwishesgif.R

@Preview
@Composable
fun QuotesPreviewScreen(){

}

@Composable
fun QuotesPreviewScreen(quote: String) {
    Scaffold(
        topBar = { TopBar() },
        content = { QuotesPreviewScreenBody(quote) },
        bottomBar = { AppAd(nativeBannerAd) }
    )
}
@Composable
fun QuotesPreviewScreenBody(quote : String) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Box() {
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth().fillMaxHeight(.5f),
                elevation = 2.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = quote, style = MaterialTheme.typography.h6)
                    }
                }
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
    BackHandler() {
        Toast.makeText(context,"BackHandler", Toast.LENGTH_LONG).show()
    }
}