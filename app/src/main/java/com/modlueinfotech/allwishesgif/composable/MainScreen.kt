package com.modlueinfotech.allwishesgif.composable

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.AppUtils
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations

@Preview
@Composable
fun MainScreen() {
    Scaffold(
        //topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        content = { MainScreenBody(null)}
    )
}

@Composable
fun MainScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        content = {  MainScreenBody(navController)}
    )
}

@Composable
fun MainScreenBody(navController: NavController?) {
    val context = LocalContext.current
    FillBackground()
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxHeight()
                .weight(0.5f)
        ) {
            if (AppUtils.isNetWorking(LocalContext.current)) {
                AppAd(nativeAd)
            } else {
                Image(
                    painter = painterResource(id = R.drawable.name),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                    contentDescription = "Name",
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.3f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gif),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController?.navigate(NavigationDestinations.categoryScreen + "/GIF") {
                            }
                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.images),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController?.navigate(NavigationDestinations.categoryScreen + "/IMAGES") {
                            }
                        },
                    contentDescription = "Name",
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.3f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.quotes),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController?.navigate(NavigationDestinations.categoryScreen + "/QUOTES") {
                            }
                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.saved),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController?.navigate(NavigationDestinations.savedScreen) {
                            }
                        },
                    contentDescription = "Name",
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.1f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ){}
    }
    BackHandler() {
        Toast.makeText(context, "BackHandler", Toast.LENGTH_LONG).show()
    }
}
