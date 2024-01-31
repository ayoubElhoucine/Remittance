@file:Suppress("UNCHECKED_CAST")

package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.domain.entity.Country
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.components.CircularProgress
import com.ayoub.presentation.components.CountrySelector
import com.ayoub.presentation.components.FailedView
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey15
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.primary15


@Composable
internal fun NewRecipientView(
    viewModel: RecipientViewModel,
    state: RecipientState,
    onSelectRecipient: (Recipient) -> Unit,
) {
    val uiState = viewModel.countriesUiState.collectAsState()

    when (val result = uiState.value) {
        UiState.Loading -> Loading()
        is UiState.Success -> Success(
            state = state,
            data = result.data as List<Country>,
            onNewRecipient = onSelectRecipient,
        )
        is UiState.Fail -> FailedView(
            modifier = Modifier.padding(top = 40.dp),
            onRetry = viewModel::onRetryGetCountries,
        )
        UiState.Idle -> Unit
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgress(modifier = Modifier.size(25.dp))
    }
}

@Composable
private fun Success(
    state: RecipientState,
    data: List<Country>,
    onNewRecipient: (Recipient) -> Unit,
) {
    LaunchedEffect(Unit) {
        state.selectedCountry.value ?: run {
            data.firstOrNull()?.let { state.selectCountry(it) }
        }
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            text = stringResource(id = R.string.country),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = grey100,
        )
        CountrySelector(
            modifier = Modifier.padding(horizontal = 16.dp),
            selectedCountry = state.selectedCountry.value,
            countries = data,
            onSelectCountry = state::selectCountry,
        )
        ChooseContactItem()
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Divider(modifier = Modifier.padding(start = 16.dp).weight(1f), thickness = 1.dp, color = grey15)
            Text(
                text = stringResource(id = R.string.add_manually).uppercase(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = grey50,
            )
            Divider(modifier = Modifier.padding(end = 16.dp).weight(1f), thickness = 1.dp, color = grey15)
        }
        NewContactItem()
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun ChooseContactItem() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(48.dp)
            .border(width = 1.dp, color = primary15, shape = RoundedCornerShape(8.dp))
            .background(primary05, shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_list),
            contentDescription = null,
            tint = primary100,
        )
        Text(
            text = stringResource(id = R.string.choose_contact),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = primary100,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun NewContactItem() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        listOf(
            stringResource(id = R.string.phone_number),
            stringResource(id = R.string.first_name),
            stringResource(id = R.string.last_name),
        ).forEach { item ->
            Text(
                text = item,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = grey100,
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                value = "Enter Value",
                onValueChange = {},
                enabled = false,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = grey25
                )
            )
        }
    }
}