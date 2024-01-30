package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.components.CircularProgress
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.ScreenLayout

@Composable
internal fun RecipientScreen(
    viewModel: RecipientViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onWalletOptions: () -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()

    ScreenLayout(
        header = {
            HeaderView(title = R.string.who_sending, onBack = onBack)
        }
    ) {
        when (val result = uiState.value) {
            UiState.Loading -> Loading(modifier = Modifier.fillParentMaxSize())
            is UiState.Success -> {
                (result.data as? List<Recipient>)?.let {
                    Success(data = it)
                }
            }
            else -> Unit
        }
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgress()
    }
}

@Composable
private fun Success(
    data: List<Recipient>,
) {

}