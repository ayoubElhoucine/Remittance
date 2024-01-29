package com.ayoub.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayoub.presentation.R
import com.ayoub.presentation.ui.theme.grey05
import com.ayoub.presentation.ui.theme.grey25
import com.ayoub.presentation.ui.theme.grey50
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.white

private enum class Actions {
    TOP_UP,
    WITHDRAW,
    GET_IBAN,
    ANALYTICS,
}

@Composable
internal fun HomeActionsView() {
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp).wrapContentSize(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(Actions.entries) { _, action ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .shadow(elevation = 20.dp, shape = RoundedCornerShape(16.dp), spotColor = grey05)
                    .background(white, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(primary05),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = icon(action)),
                        contentDescription = null,
                        tint = primary100
                    )
                }
                Text(
                    text = stringResource(id = title(action)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = primary100,
                )
            }
        }
    }
}

private fun title(action: Actions): Int {
    return when (action) {
        Actions.TOP_UP -> R.string.top_up
        Actions.WITHDRAW -> R.string.withdraw_money
        Actions.GET_IBAN -> R.string.get_iban
        Actions.ANALYTICS -> R.string.view_analytics
    }
}

private fun icon(action: Actions): Int {
    return when (action) {
        Actions.TOP_UP -> R.drawable.ic_empty_wallet_add
        Actions.WITHDRAW -> R.drawable.ic_wallet_minus
        Actions.GET_IBAN -> R.drawable.ic_card
        Actions.ANALYTICS -> R.drawable.ic_percentage_square
    }
}