package com.example.allwishescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allwishescompose.composable.*
import com.example.allwishescompose.ui.theme.AllWishesComposeTheme
import com.example.allwishescompose.utils.NavigationDestinations
import com.example.allwishescompose.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
                            ImagePreviewScreen(imgURL = imgURL)
                        }
                        composable(NavigationDestinations.quotesPreviewScreen+"/{quote}") {navBackStack ->
                            // Extracting the argument
                            val quote = navBackStack.arguments?.getString("quote")!!
                            QuotesPreviewScreen(quote = quote)
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