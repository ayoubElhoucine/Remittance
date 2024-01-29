package com.ayoub.data.network.api

import com.ayoub.data.entity.CountryResponse
import com.ayoub.data.entity.RecipientResponse
import retrofit2.http.GET

interface CountryApi {

    @GET("MonecoHQ/fake-api/countries")
    suspend fun getCountries(): List<CountryResponse>?

}