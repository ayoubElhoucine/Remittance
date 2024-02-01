package com.ayoub.presentation.ui.sendDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ayoub.presentation.R
import com.ayoub.presentation.components.MyButton
import com.ayoub.presentation.ui.theme.primary70
import com.ayoub.presentation.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun SuccessSendScreen(
    onHome: () -> Unit,
) {
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = primary70,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_success_transfer),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(id = R.string.success_transfer_msg),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    color = white,
                    textAlign = TextAlign.Center,
                )
                MyButton(
                    modifier = Modifier.padding(top = 30.dp, bottom = 70.dp),
                    text = R.string.got_it,
                    onClick = onHome,
                )
            }
        }
    }
}