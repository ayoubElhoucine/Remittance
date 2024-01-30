package com.ayoub.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.red


@Composable
fun FailedView(
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Icon(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                tint = red,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${stringResource(R.string.something_went_wrong)}, ",
                    color = grey100,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
                onRetry?.let {
                    Text(
                        modifier = Modifier.clickable(onClick = it),
                        text = stringResource(R.string.retry).lowercase(),
                        color = grey100,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }

}