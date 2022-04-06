package com.modlueinfotech.allwishesgif.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.modlueinfotech.allwishesgif.R

@Composable
fun FillBackground(){
    Image(painter = painterResource(id = R.drawable.bg),
        alignment = Alignment.Center,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
        contentDescription = "Main BG Image")
}