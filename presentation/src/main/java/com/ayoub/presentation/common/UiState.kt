package com.ayoub.presentation.common

internal sealed class UiState {
    data object Idle: UiState()
    data object Loading: UiState()
    data class Success(val data: Any? = null): UiState()
    data class Fail(val message: String? = null): UiState()
}
