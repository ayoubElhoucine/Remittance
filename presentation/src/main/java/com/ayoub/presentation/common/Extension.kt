package com.ayoub.presentation.common

import android.content.Context
import android.telephony.TelephonyManager

fun Context.getCountryFlag(iso: String): String {
    return try {
        if (iso.length >= 2) {
            val firstLetter = Character.codePointAt(iso.uppercase(), 0) - 0x41 + 0x1F1E6
            val secondLetter = Character.codePointAt(iso.uppercase(), 1) - 0x41 + 0x1F1E6
            String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
        } else ""
    } catch (e: Exception) {
        ""
    }
}