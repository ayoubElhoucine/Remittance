@file:Suppress("UNCHECKED_CAST")

package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey100

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
    }
}