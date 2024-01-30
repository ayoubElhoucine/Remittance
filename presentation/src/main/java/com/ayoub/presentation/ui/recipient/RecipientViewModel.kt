package com.ayoub.presentation.ui.recipient

import androidx.lifecycle.viewModelScope
import com.ayoub.data.repo.RecipientRepo
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import com.example.challengcodingapp.data.netowork.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RecipientViewModel @Inject constructor(
    private val repo: RecipientRepo
): BaseViewModel<UiState>() {

    init {
        getRecipients()
    }

    private fun getRecipients() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        when (val result = repo.getRecipients()) {
            is Resource.Success -> _uiState.value = UiState.Success(result.value)
            is Resource.Failure -> _uiState.value = UiState.Fail(message = result.message)
        }
    }
}