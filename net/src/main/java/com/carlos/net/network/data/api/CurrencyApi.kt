package com.carlos.net.network.data.api

import com.carlos.net.network.data.models.Currency
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CurrencyApi {

    @GET("latest")
    suspend fun getCurrency(@Query("symbols") symbols: String, @Query("base") base: String): Currency

}