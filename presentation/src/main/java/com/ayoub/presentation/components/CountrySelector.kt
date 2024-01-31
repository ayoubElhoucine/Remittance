package com.ayoub.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.domain.entity.Country
import com.ayoub.presentation.R
import com.ayoub.presentation.common.getCountryFlag
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50

@Composable
internal fun CountrySelector(
    modifier: Modifier = Modifier,
    selectedCountry: Country?,
    countries: List<Country>,
    onSelectCountry: (Country) -> Unit,
) {
    val showSelector = remember { mutableStateOf(false) }
    Box(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(width = 1.dp, color = grey25, shape = RoundedCornerShape(8.dp))
                .clickable { showSelector.value = true }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            selectedCountry?.let { country ->
                Text(text = LocalContext.current.getCountryFlag(country.iso))
                Text(
                    modifier = Modifier.weight(1f),
                    text = country.name ?: "",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = grey100,
                )
                Text(
                    text = country.code,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = grey50,
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = null,
                )
            }
        }
        DropdownMenu(
            expanded = showSelector.value,
            onDismissRequest = { showSelector.value = false }) {
            countries.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        showSelector.value = false
                        onSelectCountry(item)
                    },
                    text = {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = item.name ?: "",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = grey50,
                        )
                    },
                    leadingIcon = {
                        Text(text = LocalContext.current.getCountryFlag(item.iso))
                    },
                )
            }
        }
    }
}

@Preview
@Composable
internal fun CountrySelectorPreview() {
    CountrySelector(
        selectedCountry = Country("1", "Togo", "DZD"),
        countries = listOf(),
    ) {}
}