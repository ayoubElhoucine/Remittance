package com.ayoub.data.entity

import com.ayoub.domain.entity.Country
import com.ayoub.domain.mapper.Mapper
import com.squareup.moshi.Json

data class CountryResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String?,
    @Json(name = "currency_code") val currencyCode: String?,
): Mapper<Country> {
    override fun mapIt(): Country = Country(
        id = id,
        name = name,
        currencyCode = currencyCode,
    )
}
