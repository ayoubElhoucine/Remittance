package com.ayoub.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.white


@Composable
internal fun HeaderView(
    title: String,
    onClose: (() -> Unit)? = null,
    onBack: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier.background(white),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row {
            onBack?.let {
                ItemView(icon = R.drawable.ic_back, onClick = it)
            }
            Spacer(modifier = Modifier.weight(1f))
            onClose?.let {
                ItemView(icon = R.drawable.ic_close, onClick = it)
            }
        }
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = black,
        )
    }
}

@Composable
private fun ItemView(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(grey05)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(18.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    HeaderView(title = "Any title", onBack = {})
}