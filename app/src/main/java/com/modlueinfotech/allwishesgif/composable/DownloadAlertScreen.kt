package com.modlueinfotech.allwishesgif.composable

import android.graphics.fonts.FontStyle
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations

@Preview
@Composable
fun DownloadAlertScreen() {
    DownloadAlertScreen(null)
}
@Composable
fun DownloadAlertScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { DownloadAlertBottom(navController)},
        content = { DownloadAlertContent(navController)}
    )
}
@Composable
fun DownloadAlertContent(navController: NavController?){
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Download",
            fontSize = 30.sp ,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)

        Text("Saved Successfully !",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)

        AppAd(bannerType = nativeAd)
    }
}
@Composable
fun DownloadAlertBottom(navController: NavController?){
    MyButton(navController)
}
@Composable
fun MyButton(navController: NavController?) {

    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
        // below line is use to get
        // the context for our app.
        val context = LocalContext.current

        // below line is use to create a button.
        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.
                navController?.navigate(NavigationDestinations.savedScreen)
            },
            // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier.padding(all = Dp(10F)),

            // below line is use to set or
            // button as enable or disable.
            enabled = true,

            // below line is use to
            // add border to our button.
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(text = "GOTO COLLECTION", color = Color.White)
        }
        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.
                Toast.makeText(context, "Welcome to Geeks for Geeks", Toast.LENGTH_LONG).show()
            },
            // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier.padding(all = Dp(10F)),

            // below line is use to set or
            // button as enable or disable.
            enabled = true,

            // below line is use to
            // add border to our button.
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(text = "   OK    ", color = Color.White)
        }
    }
}