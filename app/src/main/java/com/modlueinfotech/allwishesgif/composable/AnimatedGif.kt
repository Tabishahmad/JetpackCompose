//package com.modlueinfotech.allwishesgif.composable
//
//import android.graphics.Bitmap
//import androidx.compose.runtime.Composable
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import org.jetbrains.skija.Codec
//
//@Composable
//fun GifAnimation(codec: Codec, modifier: Modifier) {
//    val transition = rememberInfiniteTransition()
//    val frameIndex by transition.animateValue(
//        initialValue = 0,
//        targetValue = codec.frameCount - 1,
//        Int.VectorConverter,
//        animationSpec = infiniteRepeatable(
//            animation = keyframes {
//                durationMillis = 0
//                for ((index, frame) in codec.framesInfo.withIndex()) {
//                    index at durationMillis
//                    durationMillis += frame.duration
//                }
//            }
//        )
//    )
//
//    val bitmap = remember { Bitmap().apply { allocPixels(codec.imageInfo) } }
//    Canvas(modifier) {
//        codec.readPixels(bitmap, frameIndex)
//        drawImage(bitmap.asImageBitmap())
//    }
//}