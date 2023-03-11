package com.carlos.data


import com.carlos.net.network.ApiCallResult
import com.carlos.net.network.data.api.CurrencyApi
import com.carlos.net.network.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import com.carlos.net.network.data.models.Currency
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val currencyApi: CurrencyApi,
    private val ioDispatcher: CoroutineDispatcher
) : MainRepository {

    override suspend fun fetchCurrencies(symbols: String, base: String): ApiCallResult<Currency> =
        safeApiCall(ioDispatcher) {
            return@safeApiCall currencyApi.getCurrency(symbols, base)
        }
}