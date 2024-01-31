package com.ayoub.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Country(
    val id: String,
    val name: String?,
    val currencyCode: String?,
): Parcelable {
    val iso: String get() {
        return when(name) {
            "Benin" -> "BJ"
            "Morocco" -> "MA"
            "Togo" -> "TG"
            "Senegal" -> "SN"
            else -> ""
        }
    }

    val code: String get() {
        return when(name) {
            "Benin" -> "+229"
            "Morocco" -> "+212"
            "Togo" -> "+228"
            "Senegal" -> "+221"
            else -> ""
        }
    }
}
