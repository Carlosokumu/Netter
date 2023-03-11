package com.carlos.data


import com.carlos.net.network.ApiCallResult
import com.carlos.net.network.data.models.Currency

interface MainRepository {


    suspend fun fetchCurrencies(symbols: String, base: String): ApiCallResult<Currency>
}