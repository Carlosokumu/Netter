package com.carlos.net.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ApiCallResult<T> = withContext(dispatcher) {
    try {
        ApiCallResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> ApiCallResult.ApiCallError
            is HttpException -> {
                val code = throwable.code()
                ApiCallResult.ServerError(code)
            }
            else -> {
                ApiCallResult.ServerError(null)
            }
        }
    }
}


