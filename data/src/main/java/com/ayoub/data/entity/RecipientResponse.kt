package com.ayoub.data.entity

import com.squareup.moshi.Json

data class RecipientResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "country") val country: String?,
    @Json(name = "mobile_wallet") val mobileWallet: String?,
)
