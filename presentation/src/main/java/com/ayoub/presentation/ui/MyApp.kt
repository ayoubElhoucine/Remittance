package com.ayoub.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.ayoub.presentation.common.LocalCoroutineScope
import com.ayoub.presentation.ui.theme.RemittanceTheme

@Composable
internal fun MyApp(
    finishActivity: () -> Unit,
) {
    val appState = rememberAppState()

    RemittanceTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CompositionLocalProvider(
                LocalCoroutineScope provides appState.coroutineScope,
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AppNavGraph(
                        appState = appState,
                    )
                }
            }
        }
    }
}