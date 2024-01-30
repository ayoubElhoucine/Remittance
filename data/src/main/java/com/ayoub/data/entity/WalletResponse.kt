package com.ayoub.data.entity

import com.ayoub.domain.entity.Wallet
import com.ayoub.domain.mapper.Mapper
import com.squareup.moshi.Json

data class WalletResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
): Mapper<Wallet> {
    override fun mapIt(): Wallet = Wallet(
        id = id,
        name = name,
    )
}
