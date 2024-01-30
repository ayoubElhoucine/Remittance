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

private enum class SendOptions {
    TO_MONECO_BALANCE,
    BANK_TRANSFER,
    SEND_TO_AFRICA,
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
            SendOptionItem(title = title(option), icon = icon(option), onClick = onSendDestination)
            Divider(thickness = 1.dp, color = grey05)
        }
    }
}

@Composable
private fun SendOptionItem(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(primary05),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = primary100,
            )
        }
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = title),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = grey100,
        )
        Icon(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}

private fun title(option: SendOptions): Int {
    return when (option) {
        SendOptions.TO_MONECO_BALANCE -> R.string.to_moneco_balance
        SendOptions.BANK_TRANSFER -> R.string.bank_transfer
        SendOptions.SEND_TO_AFRICA -> R.string.send_to_africa
    }
}

private fun icon(option: SendOptions): Int {
    return when (option) {
        SendOptions.TO_MONECO_BALANCE -> R.drawable.ic_account
        SendOptions.BANK_TRANSFER -> R.drawable.ic_market
        SendOptions.SEND_TO_AFRICA -> R.drawable.ic_web
    }
}