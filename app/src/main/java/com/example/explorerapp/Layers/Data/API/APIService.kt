package com.example.explorerapp.Layers.Data.API

import com.example.explorerapp.Layers.Data.Model.CountryResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://countriesnow.space/api/v0.1/"

interface APIService {

    //get the country from API
    @GET("countries")
    suspend fun getCountries(): CountryResponse
}

// add Retrofit to fetch the API
object RetrofitInstance {
    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}