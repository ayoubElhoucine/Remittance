package com.ayoub.domain.entity


data class Country(
    val id: String,
    val name: String?,
    val currencyCode: String?,
) {
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
