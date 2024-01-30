package com.ayoub.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ayoub.presentation.ui.home.HomeScreen
import com.ayoub.presentation.ui.recipient.RecipientScreen
import com.ayoub.presentation.ui.sendDetails.SendDetailsScreen
import com.ayoub.presentation.ui.sendDetails.SuccessSendScreen
import com.ayoub.presentation.ui.sendOptions.SendDestinationScreen
import com.ayoub.presentation.ui.sendOptions.SendOptionsScreen
import com.ayoub.presentation.ui.walletOptions.WalletOptionsScreen


private object Screens {
    const val HOME = "home_screen"
    const val SEND_OPTIONS = "send_money_options"
    const val SEND_DESTINATION = "send_money_destination_screen"
    const val RECIPIENT = "recipient_screen"
    const val WALLET_OPTIONS = "mobile_wallet_options_screen"
    const val SEND_DETAILS = "send_money_details_screen"
    const val SUCCESS_SEND = "success_send_screen"
}

@Composable
internal fun AppNavGraph(
    finishActivity: () -> Unit = {},
    appState: AppState,
    startDestination: String = Screens.HOME,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        composable(Screens.HOME) {
            BackHandler(onBack = finishActivity)
            HomeScreen {
                appState.navigateTo(Screens.SEND_OPTIONS)
            }
        }

        composable(Screens.SEND_OPTIONS) {
            BackHandler(onBack = appState::popBack)
            SendOptionsScreen(onClose = appState::popBack) {
                appState.navigateTo(Screens.SEND_DESTINATION)
            }
        }

        composable(Screens.SEND_DESTINATION) {
            BackHandler(onBack = appState::popBack)
            SendDestinationScreen(onBack = appState::popBack) {
                appState.navigateTo(Screens.RECIPIENT)
            }
        }

        composable(Screens.RECIPIENT) {
            BackHandler(onBack = appState::popBack)
            RecipientScreen(onBack = appState::popBack) {
                appState.navigateTo(Screens.WALLET_OPTIONS)
            }
        }

        composable(Screens.WALLET_OPTIONS) {
            BackHandler(onBack = appState::popBack)
            WalletOptionsScreen(onBack = appState::popBack) {
                appState.navigateTo(Screens.SEND_DETAILS)
            }
        }

        composable(Screens.SEND_DETAILS) {
            BackHandler(onBack = appState::popBack)
            SendDetailsScreen(onBack = appState::popBack) {
                appState.navigateTo(Screens.SUCCESS_SEND)
            }
        }

        composable(Screens.SUCCESS_SEND) {
            BackHandler {
                appState.popBack(Screens.HOME)
            }
            SuccessSendScreen {
                appState.popBack(Screens.HOME)
            }
        }

    }
}