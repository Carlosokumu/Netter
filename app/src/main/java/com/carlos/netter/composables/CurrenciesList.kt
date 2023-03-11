package com.carlos.netter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.carlos.net.network.data.models.Currency
import com.carlos.netter.model.CurrencyInfo


@Composable
fun CurrenciesList(
    modifier: Modifier = Modifier,
    currencyInfoList: List<CurrencyInfo>,
    currency: Currency
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 8.dp)
    ) {

        currencyInfoList.forEach { currencyInfo ->
            item(key = currencyInfo.currencySymbol) {
                CurrencyItem(currencyInfo = currencyInfo, currency = currency)
            }
            item {
                Divider(color = Color.DarkGray)
            }
        }


        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
        }
    }
}


