package com.example.allwishescompose.composable

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.allwishescompose.R

@Preview
@Composable
fun MainScreen (){
    MainScreen(null)
}

@Composable
fun MainScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize(),
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .padding()
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.name),
                alignment = Alignment.Center,
                contentDescription = "Center Image"
            )
        }
        BackHandler(enabled = true) {
//        navController.navigate("splash_screen"){
//            popUpTo("main_screen"){
//                inclusive = true
//            }
//        }
            navController?.popBackStack()
        }
    }
}