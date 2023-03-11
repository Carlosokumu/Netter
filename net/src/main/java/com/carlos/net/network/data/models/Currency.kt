package com.carlos.net.network.data.models

import com.google.gson.annotations.SerializedName

data class Currency(
    val rates: Rates
)


data class Rates(
    @SerializedName("EUR")
    var eUR: Double,
    @SerializedName("GBP")
    var gBP: Double,
    @SerializedName("JPY")
    var jPY: Double,
    @SerializedName("CNY")
    var cNY: Double,
    @SerializedName("AUD")
    var aUd: Double,
    @SerializedName("CAD")
    var cAd: Double,
    @SerializedName("CHF")
    var cHF: Double,
    @SerializedName("HKD")
    var hKD: Double,
    @SerializedName("SGD")
    var sGD: Double

)