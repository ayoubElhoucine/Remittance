package com.ayoub.presentation.ui.sendDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
internal fun rememberSendDetailsState(
    moneyInputValue: MutableState<String> = mutableStateOf(""),
    conversionRate: MutableState<Double> = mutableDoubleStateOf(655.94),
    total: MutableState<Double> = mutableDoubleStateOf(0.0),
    recipientGet: MutableState<Double> = mutableDoubleStateOf(0.0),
    showConfirmationSheet: MutableState<Boolean> = mutableStateOf(false),
) = remember(moneyInputValue, conversionRate, total, recipientGet, showConfirmationSheet) {
    SendDetailsState.Builder().build(moneyInputValue, conversionRate, total, recipientGet, showConfirmationSheet)
}

@Stable
internal class SendDetailsState(
    val moneyInputValue: MutableState<String>,
    val conversionRate: MutableState<Double>,
    val total: MutableState<Double>,
    val recipientGet: MutableState<Double>,
    val showConfirmationSheet: MutableState<Boolean>,
) {

    companion object {
        private var instance: SendDetailsState? = null
        fun onCleared() {
            instance = null
        }
    }

    fun onMoneyInputValueChanged(value: String) {
        value.toDoubleOrNull()?.let {
            moneyInputValue.value = value
        } ?: run {
            moneyInputValue.value = ""
        }
    }

    fun updateValues(total: Double, recipientGet: Double) {
        this.total.value = total
        this.recipientGet.value = recipientGet
    }

    fun showSheet() {
        showConfirmationSheet.value = true
    }

    fun hideSheet() {
        showConfirmationSheet.value = false
    }

    class Builder {
        fun build(
            moneyInputValue: MutableState<String>,
            conversionRate: MutableState<Double>,
            total: MutableState<Double>,
            recipientGet: MutableState<Double>,
            showConfirmationSheet: MutableState<Boolean>,
        ): SendDetailsState {
            instance ?: run {
                instance = SendDetailsState(moneyInputValue, conversionRate, total, recipientGet, showConfirmationSheet)
            }
            return instance!!
        }
    }

}
