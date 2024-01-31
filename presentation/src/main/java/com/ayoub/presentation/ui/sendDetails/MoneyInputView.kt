package com.ayoub.presentation.ui.sendDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey15
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary15
import com.ayoub.presentation.ui.theme.primary70
import com.ayoub.presentation.ui.theme.red


@Composable
internal fun MoneyInputView(
    modifier: Modifier = Modifier,
    state: UiState,
    value: String,
    onValueChanged: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = borderColor(state),
                shape = RoundedCornerShape(8.dp),
            )
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = value,
                onValueChange = onValueChanged,
                textStyle = TextStyle(fontSize = 18.sp, color = grey100, fontWeight = FontWeight.SemiBold),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Unspecified,
                    unfocusedContainerColor = Color.Unspecified,
                    focusedIndicatorColor = Color.Unspecified,
                    unfocusedIndicatorColor = Color.Unspecified,
                ),
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "EUR",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = grey50,
            )
        }
        Divider(thickness = 1.dp, color = contentBorderColor(state))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contentColor(state))
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.your_current_balance))
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(" 230 EUR")
                    }
                },
                fontSize = 12.sp,
                color = grey100,
            )
        }
    }
}

private fun borderColor(state: UiState): Color {
    return when(state) {
        is UiState.Fail -> red
        is UiState.Success -> primary70
        else -> grey25
    }
}

private fun contentBorderColor(state: UiState): Color {
    return when(state) {
        is UiState.Fail -> red.copy(alpha = 0.15f)
        is UiState.Success -> primary15
        else -> grey15
    }
}

private fun contentColor(state: UiState): Color {
    return when(state) {
        is UiState.Fail -> red.copy(alpha = 0.05f)
        is UiState.Success -> primary05
        else -> grey05
    }
}

@Preview
@Composable
internal fun MoneyInputViewPreview() {
    MoneyInputView(state = UiState.Success(), value = "100", onValueChanged = {})
}