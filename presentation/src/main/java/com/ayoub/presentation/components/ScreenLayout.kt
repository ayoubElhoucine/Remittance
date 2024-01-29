package com.ayoub.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ayoub.presentation.ui.theme.white


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun ScreenLayout (
    color: Color = white,
    header: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(color)
            .statusBarsPadding()
    ) {
        header?.invoke()
        content()
        Spacer(modifier = Modifier.weight(1f))
        footer?.invoke()
    }
}