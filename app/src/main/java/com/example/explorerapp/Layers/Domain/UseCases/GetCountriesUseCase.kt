package com.example.explorerapp.Layers.Domain.UseCases

import com.example.explorerapp.Layers.Data.Repositories.CountryRepositoryImpl
import com.example.explorerapp.Layers.Domain.Model.Country
import com.example.explorerapp.Layers.Domain.Repository.CountryRepository
import kotlinx.coroutines.flow.Flow

class GetCountriesUseCase(private val repository: CountryRepositoryImpl) {
    suspend fun execute(): Flow<List<Country>> {
        return repository.getCountries()
    }
}