package com.ayoub.presentation.ui.recipient

import com.ayoub.domain.entity.Recipient

internal sealed class RecipientUiState {
    data object Loading: RecipientUiState()
    data object Empty: RecipientUiState()
    data class Success(val data: List<Recipient>): RecipientUiState()
    data class Fail(val message: String? = null): RecipientUiState()
}
