package com.ayoub.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wallet(
    val id: String,
    val name: String,
): Parcelable
