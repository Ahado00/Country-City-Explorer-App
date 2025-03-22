package com.example.explorerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.explorerapp.Layers.Presentation.Screens.CountryList
import com.example.explorerapp.ui.theme.ExplorerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "countryList") {
                composable("countryList") { CountryList(navController) }
                composable("statesList/{countryName}/{countryCode}") { backStackEntry ->
                    val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
                    val countryCode = backStackEntry.arguments?.getString("countryCode") ?: ""
                    StatesList(countryName, countryCode)
                }

        }
    }
}

