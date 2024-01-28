package com.ayoub.data.entity

import com.squareup.moshi.Json

data class WalletResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
)
