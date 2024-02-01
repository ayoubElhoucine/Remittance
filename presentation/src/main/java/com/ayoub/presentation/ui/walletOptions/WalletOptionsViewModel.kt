package com.ayoub.presentation.ui.walletOptions

import androidx.lifecycle.viewModelScope
import com.ayoub.data.repo.WalletRepo
import com.ayoub.domain.entity.Recipient
import com.ayoub.domain.entity.Wallet
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import com.example.challengcodingapp.data.netowork.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class WalletOptionsViewModel @Inject constructor(
    private val repo: WalletRepo,
): BaseViewModel<UiState>() {

    private val _selectedWallet: MutableStateFlow<Wallet?> = MutableStateFlow(null)
    val selectedWallet: StateFlow<Wallet?> get() = _selectedWallet

    init {
        getWallets()
    }

    private fun getWallets() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        when(val result = repo.getWallets()) {
            is Resource.Success -> {
                (result.value as? List<Wallet>)?.let {
                    _uiState.value = UiState.Success(it)
                } ?: run {
                    _uiState.value = UiState.Fail("Something went wrong!")
                }
            }
            is Resource.Failure -> _uiState.value = UiState.Fail(result.message)
        }
    }

    fun setWallet(wallet: Wallet) {
        if (_selectedWallet.value == wallet) _selectedWallet.value = null
        else _selectedWallet.value = wallet
    }

    fun next(recipient: Recipient, onContinue: (Recipient) -> Unit) {
        selectedWallet.value?.let { wallet ->
            onContinue(
                recipient.copy(
                    mobileWallet = wallet.name
                )
            )
        }
    }

    fun onRetry() = getWallets()

}
