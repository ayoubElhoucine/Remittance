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

    // 1 euro  = 655,94 CFA
    private val conversionRate = 655.94/1

    fun calculate(
        value: String,
        balance: Double = 230.0,
        onCalculateConversion: (Double) -> Unit,
    ) {
        value.toDoubleOrNull()?.let {
            if (it == 0.0) {
                _uiState.value = UiState.Idle
                onCalculateConversion(0.0)
            }
            else if (it > 0.0 && it <= balance) {
                _uiState.value = UiState.Success()
                onCalculateConversion(it * conversionRate)
            }
            else if (it > balance || it < 0.0) {
                _uiState.value = UiState.Fail()
                onCalculateConversion(0.0)
            }
        } ?: run {
            _uiState.value = UiState.Idle
            onCalculateConversion(0.0)
        }
    }

}