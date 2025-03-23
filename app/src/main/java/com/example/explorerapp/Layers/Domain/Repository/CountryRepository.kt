package com.example.explorerapp.Layers.Domain.Repository

import com.example.explorerapp.Layers.Domain.Model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getCountries(): Flow<List<Country>>
}