package com.ayoub.presentation.ui.sendOptions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ayoub.presentation.R
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.grey05

private enum class SendToAfricaOptions(val title: Int) {
    MOBILE_WALLET(title = R.string.mobile_wallets),
    BANK_TRANSFER(title = R.string.bank_transfer),
}

@Composable
internal fun SendDestinationScreen(
    onBack: () -> Unit,
    onRecipient: () -> Unit,
) {
    ScreenLayout(
        header = {
            HeaderView(title = R.string.send_to_africa, onBack = onBack)
        }
    ) {
        Spacer(modifier = Modifier.height(it.calculateTopPadding()))
        Divider(thickness = 1.dp, color = grey05)
        SendToAfricaOptions.entries.forEach { option ->
            OptionItem(title = option.title, icon = R.drawable.ic_arrow_send, onClick = onRecipient)
            Divider(thickness = 1.dp, color = grey05)
        }
    }
}