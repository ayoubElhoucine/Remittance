package com.ayoub.presentation.common

import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.CoroutineScope


internal val LocalCoroutineScope = staticCompositionLocalOf<CoroutineScope> {
    error("No coroutine scope provided!")
}