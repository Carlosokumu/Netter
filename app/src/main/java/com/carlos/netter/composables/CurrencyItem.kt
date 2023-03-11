package com.carlos.netter.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.carlos.net.network.data.models.Currency
import com.carlos.netter.model.CurrencyInfo
import com.carlos.netter.utils.getRate


@Composable
fun CurrencyItem(
    modifier: Modifier = Modifier,
    itemSeparation: Dp = 16.dp,
    iconModifier: Modifier = Modifier,
    currencyInfo: CurrencyInfo,
    currency: Currency
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clickable { }
                .padding(vertical = itemSeparation)
        ) {
            CountryFlag(iconModifier.size(64.dp), imageUrl = currencyInfo.flagUrl)
            Spacer(modifier = Modifier.width(16.dp))
            CurrencyContent(currencyInfo = currencyInfo)
        }
        Text(
            text = currency.getRate(currencyInfo), color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineLarge
        )
    }

}

@Composable
fun CountryFlag(modifier: Modifier, imageUrl: String) {
    AsyncImage(
        modifier = modifier.size(24.dp),
        model = imageUrl,
        contentDescription = null
    )
}

@Composable
private fun CurrencyContent(
    modifier: Modifier = Modifier,
    currencyInfo: CurrencyInfo
) {
    Column(modifier) {
        Text(
            text = currencyInfo.currencyName,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(
                vertical = 2.dp
            )
        )
        Text(
            text = currencyInfo.currencySymbol,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall
        )

    }


}