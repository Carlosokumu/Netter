package com.carlos.net.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import com.carlos.net.BuildConfig.API_KEY

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url)
            .addHeader("apikey", API_KEY).build()
        Timber.d(request.toString())
        return chain.proceed(request)
    }
}