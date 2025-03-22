package com.example.explorerapp.Layers.Presentation.ViewModel


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.explorerapp.Layers.Data.API.RetrofitInstance
import com.example.explorerapp.Layers.Data.Model.Country
import kotlinx.coroutines.launch
import androidx.compose.runtime.*




class CountryVM : ViewModel(){
    private val _countries = mutableStateOf<List<Country>>(emptyList())
    val countries: State<List<Country>> = _countries

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCountryAPI()
                if (!response.error) {
                    _countries.value = response.data
                }
            } catch (e: Exception) {
                Log.e("CountryVM", "Error fetching countries: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

}
