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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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


private enum class Pages(val title: Int, val icon: Int) {
    HOME(R.string.home, R.drawable.ic_home),
    CARDS(R.string.cards, R.drawable.ic_credit),
    SENDS(R.string.send, R.drawable.ic_send),
    TONOINES(R.string.tontines, R.drawable.ic_money),
    SETTINGS(R.string.settings, R.drawable.ic_setting)
}

@Composable
internal fun NavigationBarView(
    onSendOptions: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            .background(white),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Divider(thickness = 1.dp, color = grey05)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Pages.entries.forEach { page ->
                if (page == Pages.SENDS) {
                    SendItem(
                        modifier = Modifier.weight(1f),
                        onClick = onSendOptions,
                    )
                } else {
                    TabItem(
                        modifier = Modifier.weight(1f),
                        title = page.title,
                        icon = page.icon,
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
            .clip(CircleShape)
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
                .shadow(elevation = 6.dp, shape = CircleShape, spotColor = grey50)
                .background(accent100, shape = CircleShape)
                .clip(CircleShape)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                tint = black,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarViewPreview() {
    NavigationBarView {

    }
}