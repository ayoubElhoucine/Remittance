package com.ayoub.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ayoub.presentation.ui.theme.primary100

@Composable
internal fun CircularProgress(
    modifier: Modifier = Modifier,
    color: Color = primary100,
) {
    CircularProgressIndicator(
        modifier = modifier,
        strokeWidth = 2.dp,
        color = color,
    )
}