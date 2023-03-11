package com.carlos.netter

import com.carlos.netter.composables.CountryFlag
import com.carlos.netter.model.CurrencyInfo

object Db {

    var currencyInfo = mutableListOf<CurrencyInfo>()
    fun getCurrencyInfoList(): List<CurrencyInfo> {
        var currencyInfoEuro = CurrencyInfo(
            currencyName = "Euro",
            flagUrl = "https://countryflagsapi.com/png/eu",
            "EUR"
        )
        var currencyInfoJapanese = CurrencyInfo(
            currencyName = "Japanese Yen",
            flagUrl = "https://countryflagsapi.com/png/jp",
            "JPY"
        )
        var currencyInfoBp = CurrencyInfo(
            currencyName = "British Pound Sterling",
            flagUrl = "https://countryflagsapi.com/png/vgb",
            "GBP"
        )
        var currencyInfoRn = CurrencyInfo(
            currencyName = "Renminbi",
            flagUrl = "https://countryflagsapi.com/png/cn",
            "CNY"
        )
        var currencyInfoAu = CurrencyInfo(
            currencyName = "Australian Dollar",
            flagUrl = "https://countryflagsapi.com/png/au",
            "AUD"
        )
        var currencyInfoCanadianDollar = CurrencyInfo(
            currencyName = "Canadian Dollar",
            flagUrl = "https://countryflagsapi.com/png/ca",
            "CAD"
        )
        var currencyInfoSwiss = CurrencyInfo(
            currencyName = "Canadian Dollar",
            flagUrl = "https://countryflagsapi.com/png/ch",
            "CHF"
        )
        var currencyInfoHongDollar = CurrencyInfo(
            currencyName = "HongKong Dollar",
            flagUrl = "https://countryflagsapi.com/png/hk",
            "HKD"
        )
        var currencyInfoSing = CurrencyInfo(
            currencyName = "Singapore Dollar",
            flagUrl = "https://countryflagsapi.com/png/sg",
            currencySymbol = "SGD"
        )





        currencyInfo.apply {
            add(currencyInfoEuro)
            add(currencyInfoJapanese)
            add(currencyInfoBp)
            add(currencyInfoAu)
            add(currencyInfoRn)
            add(currencyInfoCanadianDollar)
            add(currencyInfoSwiss)
            add(currencyInfoHongDollar)
            add(currencyInfoSing)
        }
        return currencyInfo
    }

}