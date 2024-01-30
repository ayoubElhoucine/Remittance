package com.ayoub.data.network

import com.ayoub.domain.mapper.Mapper
import com.example.challengcodingapp.data.netowork.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

internal interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val result = apiCall.invoke()
                if (result is List<*>) Resource.Success(result.map { (it as? Mapper<*>)?.mapIt() })
                else if (result is Mapper<*>) Resource.Success(result.mapIt())
                else Resource.Success(result)
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(
                            false,
                            400,
                            throwable.response()?.message() ?: "somthing went wrong",
                            throwable.response()?.errorBody()
                        )
                    }
                    else -> {
                        Resource.Failure(true, 0, "net_work_exception", null)
                    }
                }
            }
        }
    }
}