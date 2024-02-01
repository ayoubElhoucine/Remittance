package com.ayoub.presentation.ui.sendDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.R
import com.ayoub.presentation.components.MyButton
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey15
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ConfirmationSheet(
    recipient: Recipient,
    sendingValue: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = white,
        windowInsets = WindowInsets(0,0,0,0),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp).navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.confirm_transfer),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = grey100,
                textAlign = TextAlign.Start,
            )
            ViewItem(title = stringResource(id = R.string.you_sending), value = sendingValue)
            ViewItem(title = stringResource(id = R.string.to), value = recipient.name)
            ViewItem(title = stringResource(id = R.string.via), value = recipient.mobileWallet ?: "")
            MyButton(modifier = Modifier.padding(top = 40.dp, bottom = 16.dp), text = R.string.confirm, onClick = onConfirm)
        }
    }
}

@Composable
private fun ViewItem(
    title: String,
    value: String,
) {
    Text(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        text = title,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = grey50,
        textAlign = TextAlign.Start,
    )
    Text(
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
        text = value,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = grey100,
        textAlign = TextAlign.Start,
    )
}