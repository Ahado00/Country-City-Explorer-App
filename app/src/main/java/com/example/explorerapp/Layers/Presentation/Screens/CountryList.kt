package com.example.explorerapp.Layers.Presentation.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.explorerapp.Layers.Presentation.ViewModel.CountryVM
import com.example.explorerapp.Layers.Domain.Model.Country

@Composable
fun CountryList(
    navController: NavController,
    viewModel: CountryVM = viewModel()
) {
    val countries by viewModel.countries.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "Countries List",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color(0xFF33573b)
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(countries) { country ->
                    CountryItem(country) {
                        navController.navigate("statesList/${country.name}/${country.countryCode}")
                    }
                }
            }
        }
    }
}

@Composable
fun CountryItem(
    country: Country,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF33573b))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = country.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF1F1F1)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Country Code: ${country.countryCode}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFE6E6E6)
            )
        }
    }
}
