package com.ayoub.data.entity

import com.squareup.moshi.Json

data class CountryResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String?,
    @Json(name = "currency_code") val currencyCode: String?,
)
