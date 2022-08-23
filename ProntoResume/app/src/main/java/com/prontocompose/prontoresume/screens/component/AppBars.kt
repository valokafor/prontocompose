package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prontocompose.prontoresume.ui.theme.Colors
import com.prontocompose.prontoresume.ui.theme.poppinsFont

@Composable
fun ProntoResumeTopAppBar(titleId: Int) {
    Column {
        Text(
            text = stringResource(id = titleId),
            fontSize = 20.sp,
            fontWeight = FontWeight.W600,
            fontFamily = poppinsFont,
            color = Colors.Secondary_1,
            modifier = Modifier.padding(
                start = 30.dp,
                end = 30.dp,
                top = 30.dp,
                bottom = 9.dp)
        )
    }
}

@Composable
fun ProntoResumeBottomAppBar() {

}