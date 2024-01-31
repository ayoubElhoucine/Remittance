@file:Suppress("UNCHECKED_CAST")

package com.ayoub.presentation.ui.walletOptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.domain.entity.Recipient
import com.ayoub.domain.entity.Wallet
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.components.CircularProgress
import com.ayoub.presentation.components.FooterView
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.MyButton
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey15
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.white

@Composable
internal fun WalletOptionsScreen(
    viewModel: WalletOptionsViewModel = hiltViewModel(),
    recipient: Recipient,
    onBack: () -> Unit,
    onSendDetails: (Recipient) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()
    val selectedWallet = viewModel.selectedWallet.collectAsState()
    
    ScreenLayout(
        header = {
            HeaderView(title = R.string.choose_wallet, onBack = onBack)
        },
        footer = {
            when(uiState.value) {
                is UiState.Success -> FooterView(enabled = selectedWallet.value != null) {
                    viewModel.next(recipient, onSendDetails)
                }
                else -> Unit
            }
        }
    ) {
        Spacer(modifier = Modifier
            .padding(top = 16.dp)
            .height(it.calculateTopPadding()))
        when(val result = uiState.value) {
            UiState.Loading -> Loading()
            is UiState.Success -> Success(
                data = result.data as List<Wallet>,
                selectedWallet = selectedWallet.value,
                onSelect = viewModel::setWallet,
            )
            is UiState.Fail -> TODO()
            UiState.Idle, null -> TODO()
        }
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(top = 60.dp).fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        CircularProgress(modifier = Modifier.size(25.dp))
    }
}

@Composable
private fun Success(
    data: List<Wallet>,
    selectedWallet: Wallet?,
    onSelect: (Wallet) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .height((data.size * 88 + 10).dp)
            .padding(horizontal = 16.dp),
    ) {
        itemsIndexed(data) { _, item ->
            WalletItem(wallet = item, isSelected = selectedWallet == item, onSelect = onSelect)
        }
    }
}

@Composable
private fun WalletItem(
    wallet: Wallet,
    isSelected: Boolean,
    onSelect: (Wallet) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(72.dp)
            .background(
                color = if (isSelected) primary05 else Color.Unspecified,
                shape = RoundedCornerShape(12.dp),
            )
            .border(
                width = if (isSelected) 1.5.dp else 1.dp,
                color = if (isSelected) primary100 else grey15,
                shape = RoundedCornerShape(12.dp),
            )
            .clip(RoundedCornerShape(12.dp))
            .clickable { onSelect(wallet) }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = image(wallet)),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = wallet.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = grey100,
        )
    }
}

private fun image(wallet: Wallet): Int {
    return when (wallet.id) {
        "1" -> R.drawable.image_wave
        "2" -> R.drawable.image_mtn
        "3" -> R.drawable.image_orange
        else -> R.drawable.image_wave
    }
}