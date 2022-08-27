package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prontocompose.prontoresume.ui.theme.Colors
import com.prontocompose.prontoresume.ui.theme.Colors.Blue
import com.prontocompose.prontoresume.ui.theme.Colors.Secondary_2
import com.prontocompose.prontoresume.ui.theme.Colors.Secondary_3

@Composable
fun AppButton(
    modifier: Modifier,
    text: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Colors.Blue,
            contentColor = Color.White,
            disabledBackgroundColor = Colors.Secondary_3,
            disabledContentColor = Colors.Secondary_2
        ),
        contentPadding = PaddingValues(horizontal = 21.dp, vertical = 12.dp),
        enabled = enable
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = poppins
        )
    }
}

@Composable
fun AppOutlinedButton(
    modifier: Modifier,
    text: String,
    radius: Dp = 12.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 21.dp, vertical = 12.dp),
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(radius),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Colors.Blue,
            backgroundColor = Color.Transparent
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Colors.Blue
        ),
        contentPadding = contentPadding

    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = poppins
        )
    }
}