package com.modlueinfotech.allwishesgif.composable

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.R
import com.funwithphotography.namephotooncake.util.AdUtils
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {


    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo( targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1500)
        AdUtils.changeComposable(navController, NavigationDestinations.mainScreen)
//        navController.navigate(NavigationDestinations.mainScreen){
//            popUpTo(NavigationDestinations.splashScreen){
//                inclusive = true
//            }
//        }
    }
    Image(painter = painterResource(id = R.drawable.bg),
        alignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
        contentDescription = "Main BG Image")

    Box(modifier = Modifier
        .padding()
        .fillMaxSize(), contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.name),
            alignment = Alignment.Center,
            contentDescription = "Center Image")
    }



}