package com.example.explorerapp.Layers.Data.Mapper


import com.example.explorerapp.Layers.Data.Model.Country as DataCountry
import com.example.explorerapp.Layers.Domain.Model.Country as DomainCountry

fun DataCountry.toDomain(): DomainCountry {
    return DomainCountry(
        name = this.name,
        countryCode = this.countryCode
    )
}
