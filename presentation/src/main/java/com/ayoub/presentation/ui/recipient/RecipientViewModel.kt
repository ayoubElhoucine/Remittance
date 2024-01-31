package com.ayoub.presentation.ui.recipient

import androidx.lifecycle.viewModelScope
import com.ayoub.data.repo.CountryRepo
import com.ayoub.data.repo.RecipientRepo
import com.ayoub.domain.entity.Country
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.base.BaseViewModel
import com.ayoub.presentation.common.UiState
import com.example.challengcodingapp.data.netowork.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RecipientViewModel @Inject constructor(
    private val recipientRepo: RecipientRepo,
    private val countryRepo: CountryRepo,
): BaseViewModel<RecipientUiState>() {

    private val _countriesUiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val countriesUiState: StateFlow<UiState> get() = _countriesUiState

    private var recipientList: List<Recipient>? = null

    init {
        getRecipients()
        getCountries()
    }

    private fun getRecipients() = viewModelScope.launch {
        _uiState.value = RecipientUiState.Loading
        when (val result = recipientRepo.getRecipients()) {
            is Resource.Success -> {
                (result.value as? List<Recipient>)?.let { data ->
                    recipientList = data
                    if (data.isEmpty()) _uiState.value = RecipientUiState.Empty
                    else _uiState.value = RecipientUiState.Success(data)
                } ?: run { _uiState.value = RecipientUiState.Fail("Something went wrong") }
            }
            is Resource.Failure -> _uiState.value = RecipientUiState.Fail(message = result.message)
        }
    }

    private fun getCountries() = viewModelScope.launch {
        _countriesUiState.value = UiState.Loading
        when (val result = countryRepo.getCountries()) {
            is Resource.Success -> {
                (result.value as? List<Country>)?.let { data ->
                    _countriesUiState.value = UiState.Success(data)
                } ?: run { _countriesUiState.value = UiState.Fail("Something went wrong") }
            }
            is Resource.Failure -> _countriesUiState.value = UiState.Fail(message = result.message)
        }
    }

    fun onRetryGetRecipient() = getRecipients()

    fun onRetryGetCountries() = getCountries()

    fun filter(text: String) {
        recipientList?.filter { it.toString().uppercase().contains(text.uppercase()) }?.let { data ->
            if (data.isEmpty()) _uiState.value = RecipientUiState.Empty
            else _uiState.value = RecipientUiState.Success(data)
        }
    }

    fun createRecipientAndContinue(country: Country, onContinue: (Recipient) -> Unit) {
        onContinue(
            Recipient(
                id = "any id",
                name = "Any name",
                country = country.name,
                mobileWallet = null,
            )
        )
    }
}