package com.ayoub.presentation.ui.sendDetails

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.domain.entity.Recipient

@Composable
internal fun SendDetailsScreen(
    viewModel: SendDetailsViewModel = hiltViewModel(),
    recipient: Recipient,
    onBack: () -> Unit,
    onSuccess: () -> Unit,
) {

}