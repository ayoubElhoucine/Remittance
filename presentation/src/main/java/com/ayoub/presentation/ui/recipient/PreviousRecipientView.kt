package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.components.CircularProgress

@Composable
internal fun PreviousRecipientView(
    viewModel: RecipientViewModel,
    onSelectRecipient: (Recipient) -> Unit,
) {

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