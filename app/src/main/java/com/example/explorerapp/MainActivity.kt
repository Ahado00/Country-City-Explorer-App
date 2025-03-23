package com.example.explorerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.explorerapp.Layers.Presentation.Screens.CountryList
import com.example.explorerapp.Layers.Presentation.Screens.StatesListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "countryList") {
                composable("countryList") { CountryList(navController) }
                composable("statesList/{countryName}/{countryCode}") { backStackEntry ->
                    val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
                    val countryCode = backStackEntry.arguments?.getString("countryCode") ?: ""
                    StatesListScreen(countryName, countryCode)
                }
            }
        }
    }
}
