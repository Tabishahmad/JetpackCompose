package com.modlueinfotech.allwishesgif.composable

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.funwithphotography.namephotooncake.util.AdUtils
import com.modlueinfotech.allwishesgif.MainActivity

val bannerAd : Int = 1
val nativeAd : Int = 2
val nativeBannerAd : Int = 3

@Composable
fun AppAd(bannerType : Int){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
            elevation = 2.dp,
    ){
        //widget.ImageView
        AndroidView(factory = { ctx ->
            LinearLayout(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                when(bannerType){
                    bannerAd->{
                        AdUtils.showBanner(MainActivity.mainActivity,this)
                    }
                    nativeBannerAd->{
                        AdUtils.showNativeBanner(MainActivity.mainActivity,this)
                    }
                    nativeAd->{
                        AdUtils.showNative(MainActivity.mainActivity,this)
                    }
                }
            }
        })
    }
}