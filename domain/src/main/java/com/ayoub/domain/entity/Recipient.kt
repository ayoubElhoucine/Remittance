package com.ayoub.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Recipient(
    val id: String,
    val name: String,
    val country: String?,
    val mobileWallet: String?,
): Parcelable
