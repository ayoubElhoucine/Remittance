package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.domain.entity.Recipient
import com.ayoub.presentation.R
import com.ayoub.presentation.common.UiState
import com.ayoub.presentation.components.CircularProgress
import com.ayoub.presentation.ui.theme.black
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey100
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50

@Composable
internal fun PreviousRecipientView(
    viewModel: RecipientViewModel,
    onSelectRecipient: (Recipient) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()

    when (val result = uiState.value) {
        RecipientUiState.Loading -> Loading()
        RecipientUiState.Empty -> Empty()
        is RecipientUiState.Success -> Success(
            data = result.data,
            onSelectRecipient = onSelectRecipient
        )

        is RecipientUiState.Fail -> Unit
        null -> Unit
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgress(modifier = Modifier.size(25.dp))
    }
}

@Composable
private fun Empty(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgress()
    }
}

@Composable
private fun Success(
    data: List<Recipient>,
    onSelectRecipient: (Recipient) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            text = stringResource(id = R.string.contact_phone),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = black,
        )
        LazyColumn(
            modifier = Modifier.height((data.size * 73 + 2).dp)
        ) {
            item { Divider(thickness = 1.dp, color = grey05) }
            itemsIndexed(data) { _, item ->
                RecipientItem(
                    item = item,
                    onClick = onSelectRecipient,
                )
                Divider(thickness = 1.dp, color = grey05)
            }
        }
    }
}

@Composable
private fun RecipientItem(
    item: Recipient,
    onClick: (Recipient) -> Unit,
) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .clickable { onClick(item) }
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            modifier = Modifier
                .size(40.dp)
                .background(grey05, RoundedCornerShape(8.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .size(12.dp)
                .background(grey25, CircleShape))
            Box(modifier = Modifier
                .width(22.dp)
                .height(10.dp)
                .background(grey25, CircleShape))
            Spacer(modifier = Modifier.weight(1f))
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = grey100,
            )
            Text(
                text = "+229 98 767 289",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = grey50,
            )
        }
        Icon(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}