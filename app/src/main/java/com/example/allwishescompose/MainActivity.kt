package com.example.allwishescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allwishescompose.composable.MainScreen
import com.example.allwishescompose.composable.SplashScreen
import com.example.allwishescompose.ui.theme.AllWishesComposeTheme
import com.example.allwishescompose.utils.NavigationDestinations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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