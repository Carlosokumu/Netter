package com.carlos.netter


sealed interface MainActivityUiState {

    object Loading : MainActivityUiState


    object LoadFailed : MainActivityUiState

    data class Success(
        val currency: com.carlos.net.network.data.models.Currency
    ) : MainActivityUiState {

    }
}