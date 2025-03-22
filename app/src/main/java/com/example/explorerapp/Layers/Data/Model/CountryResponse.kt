package com.example.explorerapp.Layers.Data.Model

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    val error: Boolean,
    val msg: String,
    val data: List<Country>
)

data class Country(
    @SerializedName("country") val name: String,
    @SerializedName("iso2") val countryCode: String
)
