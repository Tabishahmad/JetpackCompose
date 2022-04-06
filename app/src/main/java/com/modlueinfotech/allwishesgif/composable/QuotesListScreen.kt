package com.modlueinfotech.allwishesgif.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import com.modlueinfotech.allwishesgif.viewmodel.AppViewModel
import kotlin.random.Random


@Preview
@Composable
fun QuotesListScreen() {
    QuotesListScreen(null,null,0)
}
val colorArray = arrayOf( 0xFFFF7A99, 0xFFFFDB7A, 0xFF798DFE, 0xFFFF9535,0xFFC5D9F1)
@Composable
fun QuotesListScreen(navController: NavController?, viewModel: AppViewModel?, position:Int?) {
    Scaffold(
        topBar = { TopBar() },
        content = { QuotesListScreenBody(navController,viewModel, position) },
        bottomBar = { AppAd(nativeBannerAd) }
    )
}
@Composable
fun QuotesListScreenBody(navController: NavController?,viewModel: AppViewModel?,position:Int?){
    val appData by viewModel?.freeGamesFlow?.collectAsState()!!
    val quoteList = appData?.get(position!!)?.getImage()
    LazyColumn(
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ), content = {
            appData?.get(position!!)?.getQuotes()?.size?.let {
                items(it) { index ->
                    val quotes = appData?.get(position)?.getQuotes()!!.get(index)?.text
                    if (quotes != null) {
                       QuotesListItem(navController,string = quotes,index)
                    }
                }
            }
        })
}

@Composable
fun QuotesListItem(navController: NavController?,string: String,position: Int) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth().clickable(onClick = {
//                val encodedUrl = URLEncoder.encode(string, StandardCharsets.UTF_8.toString())
                println("QuotesPreviewScreenBody 1 "+position)
//                navController?.navigate(NavigationDestinations.imageNGifScreen + "/$position")
                navController?.navigate(NavigationDestinations.quotesPreviewScreen+"/$position"+"/$string")
            }),
        elevation = 2.dp,
        backgroundColor = Color(colorArray[position%5]),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = string, style = MaterialTheme.typography.h6)
            }
        }
    }
}
fun getRandomNumber(min: Int, max: Int) : Int{
    return Random.nextInt(max - min + 1) + min
}
