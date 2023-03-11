package com.carlos.netter.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import com.carlos.netter.Db
import com.carlos.netter.MainActivityUiState
import com.carlos.netter.MainActivityViewModel
import com.carlos.netter.components.LoadingWheel

@Composable
fun CurrencyScreen(modifier: Modifier = Modifier, mainActivityViewModel: MainActivityViewModel) {

    val mainActivityUiState by mainActivityViewModel.uiState.collectAsState(initial = MainActivityUiState.Loading)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (mainActivityUiState) {
            is MainActivityUiState.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    LoadingWheel(contentDesc = "Loading", modifier = Modifier.align(Center))
                }
            }
            is MainActivityUiState.LoadFailed -> {
                LoadFailedEmptyScreen()
            }
            is MainActivityUiState.Success -> {
                CurrenciesList(
                    currencyInfoList = Db.getCurrencyInfoList(),
                    currency = (mainActivityUiState as MainActivityUiState.Success).currency
                )
            }
        }

    }
}

