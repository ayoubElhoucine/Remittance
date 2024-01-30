package com.ayoub.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    content: @Composable LazyItemScope.() -> Unit
) {
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .background(color)
            .statusBarsPadding(),
        topBar = {
            header?.invoke()
        },
        bottomBar = {
            footer?.invoke()
        },
        containerColor = color
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
        ) {
            item {
                content()
            }
        }
    }
}