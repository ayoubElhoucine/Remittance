package com.ayoub.presentation.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.ui.theme.accent100
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.white


private enum class Pages(val title: String) {
    HOME("home"), CARDS("Cards"), SENDS("Send"), TONOINES("Tonotines"), SETTINGS("Settings")
}

@Composable
internal fun NavigationBarView(
    onSendOptions: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(white),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(grey05))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            listOf(Pages.HOME, Pages.CARDS, Pages.SENDS, Pages.TONOINES, Pages.SETTINGS).forEach { page ->
                if (page == Pages.SENDS) {
                    SendItem(
                        modifier = Modifier.weight(1f),
                        onClick = onSendOptions,
                    )
                } else {
                    TabItem(
                        modifier = Modifier.weight(1f),
                        title = title(page),
                        icon = icon(page),
                        isSelected = page == Pages.HOME
                    ) {}
                }
            }
        }
    }
}

@Composable
private fun TabItem(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (isSelected) primary100 else grey50,
        )
        Text(
            text = stringResource(id = title),
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) primary100 else grey50,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun SendItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .shadow(elevation = 3.dp, shape = CircleShape)
                .background(accent100, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                tint = black,
            )
        }
    }
}

private fun title(page: Pages): Int {
    return when (page) {
        Pages.HOME -> R.string.home
        Pages.CARDS -> R.string.cards
        Pages.SENDS -> R.string.send
        Pages.TONOINES -> R.string.tontines
        Pages.SETTINGS -> R.string.settings
    }
}

private fun icon(page: Pages): Int {
    return when (page) {
        Pages.HOME -> R.drawable.ic_home
        Pages.CARDS -> R.drawable.ic_credit
        Pages.SENDS -> R.drawable.ic_send
        Pages.TONOINES -> R.drawable.ic_money
        Pages.SETTINGS -> R.drawable.ic_setting
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarViewPreview() {
    NavigationBarView {

    }
}