package com.ayoub.presentation.ui.home

import android.app.Application
import android.content.Context
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val application: Application,
): BaseViewModel<UiState>() {

    private val context: Context get() = application.applicationContext

}