package com.ayoub.data.repo

import com.ayoub.data.network.SafeApiCall
import com.ayoub.data.network.api.RecipientApi
import javax.inject.Inject

class RecipientRepo @Inject constructor(
    private val api: RecipientApi
) : SafeApiCall {

    suspend fun getRecipients() = safeApiCall(apiCall = api::getRecipients)

}