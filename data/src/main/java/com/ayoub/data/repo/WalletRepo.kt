package com.ayoub.data.repo

import com.ayoub.data.network.SafeApiCall
import com.ayoub.data.network.api.WalletApi
import javax.inject.Inject

class WalletRepo @Inject constructor(
    private val api: WalletApi
) : SafeApiCall {

    suspend fun getWallets() = safeApiCall(apiCall = api::getWallets)

}