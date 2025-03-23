package com.example.explorerapp.Layers.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.explorerapp.Layers.Presentation.Screens.CountryList
import com.example.explorerapp.Layers.Presentation.Screens.StatesList

//import com.example.explorerapp.Layers.Presentation.Screens.StateList

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "countryList") {

        composable("countryList") {
            CountryList(navController = navController)
        }

        composable("statesList/{countryName}") { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
            val countryCode = backStackEntry.arguments?.getString("countryCode") ?: ""

            // StatesList(navController = navController)
        }
    }
}