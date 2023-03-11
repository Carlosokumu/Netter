package com.carlos.netter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlos.data.MainRepository
import com.carlos.net.network.ApiCallResult
import com.carlos.netter.utils.getSymbols
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {


    private val _uiState: MutableStateFlow<MainActivityUiState> = MutableStateFlow(
        MainActivityUiState.Loading
    )
    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()


    fun fetchCurrencies() = viewModelScope.launch {
        when (val result = mainRepository.fetchCurrencies(symbols = getSymbols(), base = "USD")) {
            is ApiCallResult.ApiCallError -> {
                _uiState.update {
                    MainActivityUiState.LoadFailed
                }
            }
            is ApiCallResult.Success -> {
                val currency = result.data
                _uiState.update {
                    MainActivityUiState.Success(currency)
                }

            }
            is ApiCallResult.ServerError -> {
                //To a user's perspective,a server error is a LoadFailure
                _uiState.update {
                    MainActivityUiState.LoadFailed
                }
            }
        }
    }
}