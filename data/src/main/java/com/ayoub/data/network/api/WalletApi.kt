package com.ayoub.data.network.api

import com.ayoub.data.entity.RecipientResponse
import com.ayoub.data.entity.WalletResponse
import retrofit2.http.GET

interface WalletApi {

    @GET("MonecoHQ/fake-api/wallets")
    suspend fun getWallets(): List<WalletResponse>?

}