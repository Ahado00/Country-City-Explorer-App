package com.example.explorerapp.Layers.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.explorerapp.Layers.Data.API.RetrofitInstance
import com.example.explorerapp.Layers.Data.Model.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountryVM : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCountries()
                if (!response.error) {
                    _countries.value = response.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
