package com.example.explorerapp.Layers.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.explorerapp.Layers.Data.API.RetrofitInstance
import com.example.explorerapp.Layers.Data.Model.States
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StatesVM : ViewModel(){
    private val _states = MutableStateFlow<List<States>>(emptyList())
    val states: StateFlow<List<States>> = _states

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getStates()
                if (!response.error) {
                    _states.value = response.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
