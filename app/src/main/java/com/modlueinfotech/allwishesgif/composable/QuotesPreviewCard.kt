package com.modlueinfotech.allwishesgif.composable

import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.AppUtils
import com.modlueinfotech.allwishesgif.utils.MyImageUtils

@Composable
fun QuotesPreviewCard(quote : String,position: Int?) {
    println("QuotesPreviewScreenBody "+position)
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Box() {
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(.5f),
                elevation = 2.dp,
                backgroundColor = Color(colorArray[position!!%5]),
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

            }
        }
    }
}