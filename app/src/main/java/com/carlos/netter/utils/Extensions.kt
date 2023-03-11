package com.carlos.netter.utils

import com.carlos.net.network.data.models.Currency
import com.carlos.netter.model.CurrencyInfo
import java.math.RoundingMode
import java.text.DecimalFormat

/*
   * Maps each  currency Symbol to the respective rate
 */
fun Currency.getRate(currencyInfo: CurrencyInfo) = when (currencyInfo.currencySymbol) {
    "EUR" -> this.rates.eUR.roundOffDecimal().toString()
    "GBP" -> this.rates.gBP.roundOffDecimal().toString()
    "JPY" -> this.rates.jPY.roundOffDecimal().toString()
    "AUD" -> this.rates.aUd.roundOffDecimal().toString()
    "CAD" -> this.rates.cAd.roundOffDecimal().toString()
    "CHF" -> this.rates.cHF.roundOffDecimal().toString()
    "HKD" -> this.rates.hKD.roundOffDecimal().toString()
    "SGD" -> this.rates.sGD.roundOffDecimal().toString()
    "CNY" -> this.rates.cNY.roundOffDecimal().toString()
    else -> ""
}


/*
   * Gets Top 10  symbols for most traded currencies according to Wikipedia(https://en.wikipedia.org/wiki/Template:Most_traded_currencies)
 */

fun getSymbols(): String {
    return "EUR,JPY,GBP,CNY,AUD,CAD,CHF,HKD,SGD"
}


fun Double.roundOffDecimal(): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this).toDouble()
}
