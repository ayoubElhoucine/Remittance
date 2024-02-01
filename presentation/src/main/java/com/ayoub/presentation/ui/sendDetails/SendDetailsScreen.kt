package com.ayoub.presentation.ui.sendDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.common.extension.dashed
import com.ayoub.presentation.common.extension.nicer
import com.ayoub.presentation.components.FooterView
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.blue100
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey50


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SendDetailsScreen(
    viewModel: SendDetailsViewModel = hiltViewModel(),
    recipient: Recipient,
    onBack: () -> Unit,
    onSuccess: () -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()
    val state = rememberSendDetailsState()

    ScreenLayout(
        header = {
            HeaderView(title = R.string.send_money, onBack = onBack)
        },
        footer = {
            FooterView(
                enabled = when (uiState.value) {
                    is UiState.Success -> true
                    else -> false
                },
                onClick = state::showSheet
            )
        }
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(
                    top = it
                        .calculateTopPadding()
                        .plus(16.dp)
                ),
            text = stringResource(id = R.string.how_you_sending),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = grey100,
        )
        MoneyInputView(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            state = uiState.value,
            value = state.moneyInputValue.value,
            onValueChanged = { value ->
                state.onMoneyInputValueChanged(value)
                viewModel.calculate(value, onCalculateTotal = state::updateValues)
            },
        )
        FreeRemittanceItem()
        FeesItem(state = state)
    }

    if (state.showConfirmationSheet.value) {
        ConfirmationSheet(
            recipient = recipient,
            sendingValue = "${state.recipientGet.value.nicer()} XOF",
            onDismiss = state::hideSheet,
            onConfirm = onSuccess,
        )
    }
}

@Composable
private fun FeesItem(
    state: SendDetailsState,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = stringResource(id = R.string.fees_break),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = grey100,
        )
        SingleFeeItem(title = stringResource(id = R.string.moneco_fees), value = 1.0)
        SingleFeeItem(title = stringResource(id = R.string.transfer_fees), value = 0.0)
        SingleFeeItem(stringResource(id = R.string.conversion_rate), state.conversionRate.value, "XOF")
        SingleFeeItem(title = stringResource(id = R.string.you_spend_total), value = state.total.value)
        Box(modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .dashed())
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.recipient_gets),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = grey50,
            )
            Text(
                text = "${state.recipientGet.value.nicer()} XOF",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = grey100,
            )
        }
    }
}

@Composable
private fun SingleFeeItem(
    title: String,
    value: Double,
    currency: String = "EUR"
) {
    Row {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = grey50,
        )
        Text(
            text = "${value.nicer()} $currency",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = grey100,
        )
    }
}

@Composable
private fun FreeRemittanceItem() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.yearly_free),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = grey100,
        )
        Text(
            text = stringResource(id = R.string.yearly_free_msg),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = grey50,
        )
        Text(
            text = stringResource(id = R.string.check_free_msg),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = blue100,
        )
    }
}