package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prontocompose.prontoresume.ui.theme.Colors

@Composable
fun TitleH2(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        color = Colors.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontFamily = poppins
    )
}

@Composable
fun SubTitle(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        color = Colors.Secondary_2,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontFamily = poppins
    )
}

@Composable
fun Body(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        color = Colors.Secondary_3,
        fontSize = 13.sp,
        lineHeight = 22.sp,
        textAlign = TextAlign.Start,
        fontFamily = poppins
    )
}

@Composable
fun BodyBold(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Medium,
        color = Colors.Secondary_3,
        fontSize = 14.sp,
        fontFamily = poppins
    )
}

@Composable
fun LanguageText(modifier: Modifier, text: String) {
    Text(
        modifier = modifier
            .background(color = Colors.Blue_1, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 4.dp),
        text = text,
        color = Colors.Blue,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        fontFamily = poppins
    )
}