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
) = remember(moneyInputValue, conversionRate, total, recipientGet) {
    SendDetailsState(moneyInputValue, conversionRate, total, recipientGet)
}

@Stable
internal class SendDetailsState(
    val moneyInputValue: MutableState<String>,
    val conversionRate: MutableState<Double>,
    val total: MutableState<Double>,
    val recipientGet: MutableState<Double>,
) {

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

}
