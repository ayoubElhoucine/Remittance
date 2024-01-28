package com.ayoub.data.repo

import com.ayoub.data.network.SafeApiCall
import com.ayoub.data.network.api.CountryApi
import javax.inject.Inject

class CountryRepo @Inject constructor(
    private val api: CountryApi
) : SafeApiCall {

    suspend fun getCountries() = safeApiCall(apiCall = api::getCountries)

}