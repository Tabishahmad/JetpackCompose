package com.modlueinfotech.allwishesgif.composable

import android.graphics.Matrix
import android.graphics.RectF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser

@Preview
@Composable
fun TestFigma(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
            .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
            .alpha(1f)

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(481.dp)
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                .background(Color.DarkGray)
                .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 437.dp)
                .align(Alignment.TopStart)
                .alpha(1f)


        ) {
        }


        Box(


            modifier = Modifier

                .width(375.dp)
                .height(770.dp)
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                .background(Color.Transparent)

                .padding(start = 20.dp, top = 732.dp, end = 20.dp, bottom = 0.dp)
                .align(Alignment.TopStart)
                .alpha(1f)


        ) {
        }


        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(49.dp)

                //.height(22.dp)

                .alpha(1f),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
        )


        Text(
            text = "Register",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(73.dp)

                //.height(22.dp)

                .alpha(1f),
            color = Color(red = 0.18039216101169586f, green = 0.615686297416687f, blue = 0.35686275362968445f, alpha = 1f),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
        )


        Text(
            text = "Google",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(48.dp)

                //.height(17.dp)

                .alpha(1f),
            color = Color(red = 0.30980393290519714f, green = 0.30980393290519714f, blue = 0.30980393290519714f, alpha = 1f),
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
        )


        Text(
            text = "Facebook",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(66.dp)

                //.height(17.dp)

                .alpha(1f),
            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
        )

        Box(
            modifier = Modifier
                .width(120.40065002441406.dp)
                .height(1.dp)
                .align(Alignment.TopStart)
                .border(1.dp, Color(red = 0.5098039507865906f, green = 0.5098039507865906f, blue = 0.5098039507865906f, alpha = 1f))
                .background(Color.Transparent)
        )
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
            modifier = Modifier

                .width(375.dp)
                .height(758.dp)
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                .background(Color.Transparent)

                .padding(start = 151.dp, top = 638.dp, end = 152.dp, bottom = 102.dp)
                .align(Alignment.TopStart)
                .alpha(1f)


        ) {


            Text(
                text = "Or login with",
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.sp,
                lineHeight = 18.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier

                    .width(72.dp)

                    //.height(18.dp)

                    .alpha(1f),
                color = Color(red = 0.20000000298023224f, green = 0.20000000298023224f, blue = 0.20000000298023224f, alpha = 1f),
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
            )
        }

        Box(
            modifier = Modifier
                .width(120.40065002441406.dp)
                .height(1.dp)
                .align(Alignment.TopStart)
                .border(1.dp, Color(red = 0.5098039507865906f, green = 0.5098039507865906f, blue = 0.5098039507865906f, alpha = 1f))
                .background(Color.Transparent)
        )
        Box(


            modifier = Modifier

                .width(375.dp)
                .height(812.dp)
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                .background(Color.Transparent)

                .padding(start = 40.dp, top = 695.dp, end = 317.dp, bottom = 99.dp)
                .align(Alignment.TopStart)
                .alpha(1f)


        ) {

            Canvas(
                modifier = Modifier
                    .width(14.002500534057617.dp)
                    .height(7.323750972747803.dp)
                    //.fillMaxWidth()
                    //.aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                val fillPath = PathParser.createPathFromPathData("M 3.019500119991333 7.323750972747802 C 3.3704124868277345 6.262085959938582 4.047645498068764 5.338359147127048 4.954586674611973 4.684348683078711 C 5.8615278511551825 4.030338219030374 6.951847193942947 3.6794531377668194 8.07000044647487 3.68175029948741 C 9.3375005325533 3.681750299487409 10.483499943584299 4.131750540130881 11.383500009995432 4.868250607052519 L 14.002500534057617 2.250000219740618 C 12.406500463972261 0.8587500695625532 10.361250574568349 0 8.07000044647487 0 C 4.5225003113641975 0 1.4685000085230475 2.0235003421017352 0 4.987500558617284 L 3.019500119991333 7.323750972747802 Z ")
                //fillPath.fillType = Path.FillType.EVEN_ODD
                val rectF = RectF()
                fillPath.computeBounds(rectF, true)
                val matrix = Matrix()
                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                matrix.setScale(scale, scale)
                fillPath.transform(matrix)
                val composePathFill = fillPath.asComposePath()

                drawPath(path = composePathFill, color = Color(red = 0.9176470637321472f, green = 0.26274511218070984f, blue = 0.2078431397676468f, alpha = 1f), style = Fill)
                drawPath(path = composePathFill, color = Color.Transparent, style = Stroke(width = 3f, miter = 4f, join = StrokeJoin.Round))
            }
            Canvas(
                modifier = Modifier
                    .width(13.947749137878418.dp)
                    .height(7.299038887023926.dp)
                    //.fillMaxWidth()
                    //.aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                val fillPath = PathParser.createPathFromPathData("M 11.102250293742495 2.808750078948571 C 10.284750324604927 3.3359999824097537 9.246749722522344 3.617249256736501 8.072249814272611 3.617249256736501 C 6.958553166244971 3.619536874114528 5.872351572728124 3.2714491035422473 4.967427152494972 2.622267209155102 C 4.06250273226182 1.9730853147679568 3.3847066829963124 1.055702688022829 3.029999764214195 0 L 0 2.3002491257513356 C 0.743433856795931 3.804967551760103 1.8939508394823121 5.071042467706457 3.3208667153421607 5.9546616328032265 C 4.747782591202009 6.838280797899996 6.3939034143273386 7.30402727373899 8.072249814272611 7.298998832710486 C 10.271999729668718 7.298998832710489 12.373499262683548 6.516748998895324 13.947749137878418 5.048999273679529 L 11.102999881703937 2.808750078948571 L 11.102250293742495 2.808750078948571 Z ")
                //fillPath.fillType = Path.FillType.EVEN_ODD
                val rectF = RectF()
                fillPath.computeBounds(rectF, true)
                val matrix = Matrix()
                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                matrix.setScale(scale, scale)
                fillPath.transform(matrix)
                val composePathFill = fillPath.asComposePath()

                drawPath(path = composePathFill, color = Color(red = 0.20392157137393951f, green = 0.658823549747467f, blue = 0.32549020648002625f, alpha = 1f), style = Fill)
                drawPath(path = composePathFill, color = Color.Transparent, style = Stroke(width = 3f, miter = 4f, join = StrokeJoin.Round))
            }
            Canvas(
                modifier = Modifier
                    .width(8.590499877929688.dp)
                    .height(8.38650131225586.dp)
                    //.fillMaxWidth()
                    //.aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                val fillPath = PathParser.createPathFromPathData("M 5.8754993992075235 8.38650131225586 C 7.52174925776041 6.850501020966172 8.590499877929688 4.564500801882247 8.590499877929688 1.6365003527820705 C 8.590499877929688 1.1040002931835058 8.508748934485405 0.5317500691479103 8.38649893939365 0 L 0 0 L 0 3.477750557284731 L 4.827000350046243 3.477750557284731 C 4.589250361991452 4.647000734931006 3.9495000733127275 5.552251278813117 3.0307501064288465 6.146251360028159 L 5.8754993992075235 8.38650131225586 Z ")
                //fillPath.fillType = Path.FillType.EVEN_ODD
                val rectF = RectF()
                fillPath.computeBounds(rectF, true)
                val matrix = Matrix()
                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                matrix.setScale(scale, scale)
                fillPath.transform(matrix)
                val composePathFill = fillPath.asComposePath()

                drawPath(path = composePathFill, color = Color(red = 0.29019609093666077f, green = 0.5647059082984924f, blue = 0.886274516582489f, alpha = 1f), style = Fill)
                drawPath(path = composePathFill, color = Color.Transparent, style = Stroke(width = 3f, miter = 4f, join = StrokeJoin.Round))
            }
            Canvas(
                modifier = Modifier
                    .width(3.9578371047973633.dp)
                    .height(8.013751029968262.dp)
                    //.fillMaxWidth()
                    //.aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                val fillPath = PathParser.createPathFromPathData("M 3.9578371047973633 5.713500685160766 C 3.7743535506855905 5.165182186302978 3.6811400910768466 4.59070383003232 3.681837090222247 4.012500644734289 C 3.681837090222247 3.426000536105948 3.7755869979915504 2.862750713438708 3.9495869877439143 2.336250603003817 L 0.9300873297454249 0 C 0.3123707677215797 1.2470148047581342 -0.006059957874924205 2.6208893566832714 0.00008734090179816535 4.012500644734289 C 0.00008734090180008048 5.452500869598048 0.3338373351873841 6.810000800785182 0.9278373140775686 8.013751029968262 L 3.9578371047973633 5.713500685160766 Z ")
                //fillPath.fillType = Path.FillType.EVEN_ODD
                val rectF = RectF()
                fillPath.computeBounds(rectF, true)
                val matrix = Matrix()
                val scale = minOf( size.width / rectF.width(), size.height / rectF.height() )
                matrix.setScale(scale, scale)
                fillPath.transform(matrix)
                val composePathFill = fillPath.asComposePath()

                drawPath(path = composePathFill, color = Color(red = 0.9843137264251709f, green = 0.7372549176216125f, blue = 0.019607843831181526f, alpha = 1f), style = Fill)
                drawPath(path = composePathFill, color = Color.Transparent, style = Stroke(width = 3f, miter = 4f, join = StrokeJoin.Round))
            }}

        Box(


            modifier = Modifier

                .width(375.dp)
                .height(812.dp)
                .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                .background(Color.Transparent)

                .padding(start = 40.dp, top = 742.dp, end = 317.dp, bottom = 52.dp)
                .align(Alignment.TopStart)
                .alpha(1f)


        ) {
        }
    }

}
