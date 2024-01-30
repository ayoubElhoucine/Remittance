package com.ayoub.data.entity

import com.ayoub.domain.entity.Recipient
import com.ayoub.domain.mapper.Mapper
import com.squareup.moshi.Json

data class RecipientResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "country") val country: String?,
    @Json(name = "mobile_wallet") val mobileWallet: String?,
): Mapper<Recipient> {
    override fun mapIt(): Recipient = Recipient(
        id = id,
        name = name,
        country = country,
        mobileWallet = mobileWallet,
    )
}
