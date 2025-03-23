package com.example.explorerapp.Layers.Data.API

import com.example.explorerapp.Layers.Data.Model.CountryResponse
import com.example.explorerapp.Layers.Data.Model.StatesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST


const val BASE_URL = "https://countriesnow.space/api/v0.1/"

interface APIService {

    //get the country from API
    @GET("countries")
    suspend fun getCountries(): CountryResponse

    @POST("countries/states")
    suspend fun getStates(): StatesResponse
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