package com.modlueinfotech.allwishesgif

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.modlueinfotech.allwishesgif.composable.*
import com.modlueinfotech.allwishesgif.ui.theme.AllWishesComposeTheme
import com.modlueinfotech.allwishesgif.utils.NavigationDestinations
import com.modlueinfotech.allwishesgif.viewmodel.AppViewModel
import com.sm.newadlib.app.LibSplashActivity

class MainActivity : LibSplashActivity() {
    companion object{
        lateinit var mainActivity : com.modlueinfotech.allwishesgif.MainActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        com.modlueinfotech.allwishesgif.MainActivity.Companion.mainActivity = this

        val viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        setContent {
            AllWishesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavigationDestinations.splashScreen)
                    {
                        composable(NavigationDestinations.splashScreen){
                            SplashScreen(navController)
                        }
                        composable(NavigationDestinations.mainScreen) {
                            MainScreen(navController)
                        }
                        composable(NavigationDestinations.testFigmaScreen) {
                            TestFigma()
                        }
                        composable(NavigationDestinations.categoryScreen+"/{itemType}") {navBackStack->
                            val itemType = navBackStack.arguments?.getString("itemType")!!
                            CategoryScreen(navController,viewModel,itemType)
                        }
                        composable(NavigationDestinations.imageNGifScreen+"/{position}") {navBackStack ->
                            // Extracting the argument
                            val position = navBackStack.arguments?.getInt("position")
                            ImageNGIFScreen(navController,
                                position = position,
                                viewModel)
                        }
                        composable(NavigationDestinations.quotesListScreen) {
                            QuotesListScreen(navController,viewModel,0)
                        }
                        composable(NavigationDestinations.imgPrevScreen+"/{imgURL}") {navBackStack ->
                            // Extracting the argument
                            val imgURL = navBackStack.arguments?.getString("imgURL")!!
                            ImagePreviewScreen(navController,imgURL = imgURL)
                        }
                        composable(NavigationDestinations.quotesPreviewScreen+"/{quote}") {navBackStack ->
                            // Extracting the argument
                            val quote = navBackStack.arguments?.getString("quote")!!
                            QuotesPreviewScreen(quote = quote)
                        }
                        composable(NavigationDestinations.downloadAlertScreen) {navBackStack ->
                            // Extracting the argument
                            DownloadAlertScreen(navController)
                        }
                        composable(NavigationDestinations.savedScreen) {
                            SavedScreen(navController)
                        }
                    }
                }
            }
        }
    }
}




//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    AllWishesComposeTheme {
//        Greeting("Android")
//    }
//}