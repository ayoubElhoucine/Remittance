package com.ayoub.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.presentation.R
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.primary01
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.primary70
import com.ayoub.presentation.ui.theme.walletGreen1
import com.ayoub.presentation.ui.theme.walletGreen2
import com.ayoub.presentation.ui.theme.white

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onSendOptions: () -> Unit,
) {
    ScreenLayout(
        color = primary01,
        footer = {
            NavigationBarView(onSendOptions = onSendOptions)
        }
    ) {
        HeaderItem()
        BalanceItem()
    }
}

@Composable
private fun HeaderItem() {
    Row(
        modifier = Modifier.padding(16.dp).padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.home_title),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = black,
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(grey05),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun BalanceItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(160.dp)
            .background(
                brush = Brush.horizontalGradient(colors = listOf(walletGreen1, walletGreen2)),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.your_balance),
                fontSize = 18.sp,
                color = white,
            )
            Text(
                text = "320,000",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = white,
            )
            Text(
                text = "US Dollars",
                fontSize = 14.sp,
                color = white,
            )
        }
        Image(
            modifier = Modifier.size(60.dp),
            painter = painterResource(id = R.drawable.ic_home_wallet),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BalanceItem()
}