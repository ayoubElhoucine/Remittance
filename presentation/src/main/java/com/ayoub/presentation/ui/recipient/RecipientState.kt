package com.ayoub.presentation.ui.recipient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ayoub.domain.entity.Country
import com.ayoub.presentation.R


internal enum class RecipientPages(val title: Int) {
    PREVIOUS(title = R.string.prev_recipient),
    NEW(title = R.string.new_recipient),
}

@Composable
internal fun rememberRecipientState(
    selectedPage: MutableState<RecipientPages> = mutableStateOf(RecipientPages.PREVIOUS),
    searchTextValue: MutableState<String> = mutableStateOf(""),
    selectedCountry: MutableState<Country?> = mutableStateOf(null),
) = remember(selectedPage, searchTextValue) {
    RecipientState(selectedPage, searchTextValue, selectedCountry)
}

@Stable
internal class RecipientState(
    val selectedPage: MutableState<RecipientPages>,
    val searchTextValue: MutableState<String>,
    val selectedCountry: MutableState<Country?>,
) {

    fun selectPage(page: RecipientPages) {
        selectedPage.value = page
    }

    fun onSearchValueChanged(value: String) {
        searchTextValue.value = value
    }

    fun selectCountry(country: Country) {
        selectedCountry.value = country
    }

}
