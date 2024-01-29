package com.ayoub.presentation.ui.recipient

import com.ayoub.data.repo.RecipientRepo
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class RecipientViewModel @Inject constructor(
    private val repo: RecipientRepo
): BaseViewModel<UiState>() {

}