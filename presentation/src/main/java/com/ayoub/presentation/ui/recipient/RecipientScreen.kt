package com.ayoub.presentation.ui.recipient

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.presentation.R
import com.ayoub.presentation.components.HeaderView
import com.ayoub.presentation.components.ScreenLayout
import com.ayoub.presentation.ui.theme.primary05
import com.ayoub.presentation.ui.theme.primary100
import com.ayoub.presentation.ui.theme.primary70
import com.ayoub.presentation.ui.theme.white


@Composable
internal fun RecipientScreen(
    viewModel: RecipientViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onWalletOptions: () -> Unit,
) {
    val state = rememberRecipientState()

    ScreenLayout(
        header = {
            HeaderView(title = R.string.who_sending, onBack = onBack)
        }
    ) {
        Spacer(modifier = Modifier.height(it.calculateTopPadding()))
        PagesTabItem(selectedPage = state.selectedPage.value, onSelectPage = state::selectPage)
    }
}

@Composable
private fun PagesTabItem(
    selectedPage: RecipientPages,
    onSelectPage: (RecipientPages) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(46.dp)
            .fillMaxHeight()
            .background(primary05, shape = RoundedCornerShape(8.dp))
    ) {
        RecipientPages.entries.forEach { page ->
            PageItem(modifier = Modifier.weight(1f), page = page, isSelected = page == selectedPage, onClick = onSelectPage)
        }
    }
}

@Composable
private fun PageItem(
    modifier: Modifier,
    page: RecipientPages,
    isSelected: Boolean,
    onClick: (RecipientPages) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(2.dp)
            .clickable { onClick(page) }
            .background(
                if (isSelected) primary70 else Color.Unspecified,
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = page.title),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) white else primary100
        )
    }
}