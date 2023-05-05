package com.carlos.netter

import com.carlos.netter.composables.CountryFlag
import com.carlos.netter.model.CurrencyInfo

object Db {

    var currencyInfo = mutableListOf<CurrencyInfo>()
    fun getCurrencyInfoList(): List<CurrencyInfo> {
        var currencyInfoEuro = CurrencyInfo(
            currencyName = "Euro",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/EU.png",
            "EUR"
        )
        var currencyInfoJapanese = CurrencyInfo(
            currencyName = "Japanese Yen",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/JP.png",
            "JPY"
        )
        var currencyInfoBp = CurrencyInfo(
            currencyName = "British Pound Sterling",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/VG.png",
            "GBP"
        )
        var currencyInfoRn = CurrencyInfo(
            currencyName = "Renminbi",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/CN.png",
            "CNY"
        )
        var currencyInfoAu = CurrencyInfo(
            currencyName = "Australian Dollar",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/AU.png",
            "AUD"
        )

        var currencyInfoSwiss = CurrencyInfo(
            currencyName = "Canadian Dollar",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/CA.png",
            "CHF"
        )
        var currencyInfoHongDollar = CurrencyInfo(
            currencyName = "HongKong Dollar",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/HK.png",
            "HKD"
        )
        var currencyInfoSing = CurrencyInfo(
            currencyName = "Singapore Dollar",
            flagUrl = "https://www.countryflagicons.com/SHINY/64/SG.png",
            currencySymbol = "SGD"
        )





        currencyInfo.apply {
            add(currencyInfoEuro)
            add(currencyInfoJapanese)
            add(currencyInfoBp)
            add(currencyInfoAu)
            add(currencyInfoRn)
            add(currencyInfoSwiss)
            add(currencyInfoHongDollar)
            add(currencyInfoSing)
        }
        return currencyInfo
    }

}