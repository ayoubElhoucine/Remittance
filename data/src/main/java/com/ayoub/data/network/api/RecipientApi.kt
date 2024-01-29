package com.ayoub.data.network.api

import com.ayoub.data.entity.RecipientResponse
import retrofit2.http.GET

internal interface RecipientApi {

    @GET("MonecoHQ/fake-api/recipients")
    suspend fun getRecipients(): List<RecipientResponse>?

}