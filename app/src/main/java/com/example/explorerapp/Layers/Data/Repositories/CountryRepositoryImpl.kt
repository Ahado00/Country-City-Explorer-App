package com.example.explorerapp.Layers.Data.Repositories

import com.example.explorerapp.Layers.Data.API.APIService
import com.example.explorerapp.Layers.Domain.Model.Country
import com.example.explorerapp.Layers.Domain.Repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepositoryImpl(private val apiService: APIService) : CountryRepository {

    override suspend fun getCountries(): Flow<List<Country>> = flow {
        val response = apiService.getCountries()
        emit(response.data.map { Country(it.name, it.countryCode) })
    }
}