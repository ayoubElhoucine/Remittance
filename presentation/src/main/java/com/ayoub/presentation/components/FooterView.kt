package com.ayoub.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.ayoub.presentation.R
import com.ayoub.presentation.ui.theme.grey15
import com.ayoub.presentation.ui.theme.white


@Composable
internal fun FooterView(
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .shadow(elevation = 10.dp, spotColor = grey15)
            .background(white),
        contentAlignment = Alignment.Center,
    ) {
        MyButton(
            modifier = Modifier.padding(16.dp),
            enabled = enabled,
            text = R.string.next,
            onClick = onClick,
        )
    }
}