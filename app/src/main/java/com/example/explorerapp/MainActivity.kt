package com.example.explorerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.explorerapp.Layers.Presentation.Screens.CountryList

import com.example.explorerapp.ui.theme.ExplorerAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            ExplorerAppTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Explorer App") },
                            actions = {
                                ThemeToggleSwitch(isDarkTheme) { isDarkTheme = it }
                            }
                        )
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "countryList",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("countryList") { CountryList(navController) }
                        composable("statesList/{countryName}/{countryCode}") { backStackEntry ->
                            val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
                            val countryCode = backStackEntry.arguments?.getString("countryCode") ?: ""
                            //StatesListScreen(countryName, countryCode, navController)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ThemeToggleSwitch(isDarkTheme: Boolean, onToggle: (Boolean) -> Unit) {
        Row(modifier = Modifier.fillMaxWidth().padding(end = 16.dp)) {
            Text(text = if (isDarkTheme) "Dark Mode" else "Light Mode")
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onToggle(it) }
            )
        }
    }

}
