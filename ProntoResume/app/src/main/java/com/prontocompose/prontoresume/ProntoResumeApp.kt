package com.prontocompose.prontoresume

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.prontocompose.prontoresume.screens.ProfileScreen
import com.prontocompose.prontoresume.screens.component.ProntoResumeBottomAppBar
import com.prontocompose.prontoresume.screens.component.ProntoResumeTopAppBar
import com.prontocompose.prontoresume.ui.theme.ProntoResumeTheme

@Composable
fun ProntoResumeApp() {
    ProntoResumeTheme() {
        Scaffold(
            topBar = { ProntoResumeTopAppBar(R.string.app_name) },
            bottomBar = {},
        ) { innerPadding ->
            ProfileScreen(innerPadding)
        }
    }
}

@Preview
@Composable
fun PreviewResumeApp() {
    ProntoResumeApp()
}