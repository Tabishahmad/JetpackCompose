package com.modlueinfotech.allwishesgif.composable

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations

@Preview
@Composable
fun MainScreen() {
    MainScreen(null)
}

@Composable
fun MainScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        content = { MainScreenBody(navController) }
    )
}

@Composable
fun MainScreenBody(navController: NavController?) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxHeight(fraction = 0.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.name),
                modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 0.dp),
                contentDescription = "Name",
            )
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gif),
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            navController?.navigate(NavigationDestinations.categoryScreen+"/GIF") {
                            }
                        },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.images),
                    modifier = Modifier.weight(1f).clickable {
                        navController?.navigate(NavigationDestinations.categoryScreen+"/IMAGES") {
                        }
                    },
                    contentDescription = "Name",
                )
            }
        }
        Box() {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.quotes),
                    modifier = Modifier.weight(1f).clickable {
                        navController?.navigate(NavigationDestinations.categoryScreen+"/QUOTES") {
                        }
                    },
                    contentDescription = "Name",
                )
                Image(
                    painter = painterResource(id = R.drawable.saved),
                    modifier = Modifier.weight(1f).clickable {
                        navController?.navigate(NavigationDestinations.categoryScreen+"/$"+"Saved") {
                        }
                    },
                    contentDescription = "Name",
                )
            }
        }

    }
    BackHandler() {
        Toast.makeText(context,"BackHandler",Toast.LENGTH_LONG).show()
    }
}
