package com.ayoub.presentation.ui.sendDetails

import android.app.Application
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SendDetailsViewModel @Inject constructor(
    private val application: Application,
): BaseViewModel<UiState>() {

}