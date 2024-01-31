package com.ayoub.presentation.ui.sendDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ayoub.domain.entity.Country
import com.ayoub.presentation.R


@Composable
internal fun rememberSendDetailsState(
    moneyInputValue: MutableState<String> = mutableStateOf(""),
    conversionRate: MutableState<Double> = mutableDoubleStateOf(0.0),
    total: MutableState<Double> = mutableDoubleStateOf(0.0),
) = remember(moneyInputValue, conversionRate, total) {
    SendDetailsState(moneyInputValue, conversionRate, total)
}

@Stable
internal class SendDetailsState(
    val moneyInputValue: MutableState<String>,
    val conversionRate: MutableState<Double>,
    val total: MutableState<Double>,
) {

    fun onMoneyInputValueChanged(value: String) {
        moneyInputValue.value = value
    }

}
