package com.ayoub.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.blue10
import com.ayoub.presentation.ui.theme.blue100
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.white


@Composable
internal fun TransactionsView() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.transactions),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = black,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 20.dp, shape = RoundedCornerShape(16.dp), spotColor = grey05)
                .background(white, shape = RoundedCornerShape(16.dp)),
        ) {
            repeat(4) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(blue10),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(14
                                .dp),
                            painter = painterResource(id = R.drawable.ic_stock_option),
                            contentDescription = null,
                            tint = blue100
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        Text(
                            text = stringResource(id = R.string.sent_to),
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = grey50
                        )
                        Text(
                            text = "Ralph Edwards",
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = black
                        )
                    }
                    Text(
                        text = "€ 150",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = black
                    )
                }
                if (it < 4) Divider(thickness = 1.dp, color = grey05)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionPreview() {
    TransactionsView()
}