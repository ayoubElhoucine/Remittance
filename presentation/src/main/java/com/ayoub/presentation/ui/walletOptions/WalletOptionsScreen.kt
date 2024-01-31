package com.ayoub.presentation.ui.walletOptions

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.domain.entity.Recipient

@Composable
internal fun WalletOptionsScreen(
    viewModel: WalletOptionsViewModel = hiltViewModel(),
    recipient: Recipient,
    onBack: () -> Unit,
    onSendDetails: (Recipient) -> Unit,
) {

}