package com.ayoub.presentation.ui.sendOptions

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary100

private enum class SendOptions(val title: Int, val icon: Int) {
    TO_MONECO_BALANCE(title = R.string.to_moneco_balance, icon = R.drawable.ic_account),
    BANK_TRANSFER(title = R.string.bank_transfer, icon = R.drawable.ic_market),
    SEND_TO_AFRICA(title = R.string.send_to_africa, icon = R.drawable.ic_web),
}

@Composable
internal fun SendOptionsScreen(
    onClose: () -> Unit,
    onSendDestination: () -> Unit,
) {
    ScreenLayout(
        header = {
            HeaderView(title = R.string.send_money, onClose = onClose)
        }
    ) {
        Spacer(modifier = Modifier.height(it.calculateTopPadding()))
        Divider(thickness = 1.dp, color = grey05)
        SendOptions.entries.forEach { option ->
            OptionItem(title = option.title, icon = option.icon, onClick = onSendDestination)
            Divider(thickness = 1.dp, color = grey05)
        }
    }
}