package com.ayoub.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.primary05

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onSendOptions: () -> Unit,
) {
    ScreenLayout(
        color = primary05,
        footer = {
            NavigationBarView(onSendOptions = onSendOptions)
        }
    ) {

    }
}