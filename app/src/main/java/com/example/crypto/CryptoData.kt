package com.example.crypto



import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class CryptoData(
    val asset_id_base: String?,
    val rates: Rates,
):Parcelable {
    @Parcelize
    data class Rates(
        val time: String?,
        val asset_id_quote: String?,
        val rate: Double?
    ):Parcelable
}
