package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.modlueinfotech.allwishesgif.NavigationItem
import com.modlueinfotech.allwishesgif.R
import com.modlueinfotech.allwishesgif.utils.AppUtilJava
import com.modlueinfotech.allwishesgif.utils.AppUtils

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.more_apps,
        NavigationItem.rate_us,
        NavigationItem.privacy_policy,
        NavigationItem.share
    )
    val context = LocalContext.current
    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(1f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    when(item.route){
                        "more" -> moreApps(context)
                        "rate" -> rateUs(context)
                        "privacy" -> pp(context)
                        "share" -> shareApp(context)
                    }
                }
            )
        }
    }
}
fun moreApps(context:Context) {
    AppUtilJava.getInstance().openUrl(context, context.getString(R.string.more_app_url))
}
fun pp(context:Context) {
    AppUtilJava.getInstance().openUrl(context, context.getString(R.string.pp_url))
}
fun shareApp(context:Context) {
    AppUtilJava.getInstance().shareApp(context)
}
fun rateUs(context:Context) {
    AppUtilJava.getInstance().rateUs(context)
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}