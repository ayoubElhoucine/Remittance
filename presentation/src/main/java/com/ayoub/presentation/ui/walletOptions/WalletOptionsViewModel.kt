package com.ayoub.presentation.ui.walletOptions

import com.ayoub.data.repo.WalletRepo
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class WalletOptionsViewModel @Inject constructor(
    private val repo: WalletRepo,
): BaseViewModel<UiState>() {

}