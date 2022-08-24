package com.prontocompose.prontoresume

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.prontocompose.prontoresume.navigation.NavGraph
import com.prontocompose.prontoresume.navigation.ProntoResumeTabs
import com.prontocompose.prontoresume.screens.ProfileScreen
import com.prontocompose.prontoresume.screens.component.ProntoResumeBottomAppBar
import com.prontocompose.prontoresume.screens.component.ProntoResumeTopAppBar
import com.prontocompose.prontoresume.ui.theme.ProntoResumeTheme

@Composable
fun ProntoResumeApp() {
    val navHostController = rememberNavController()
    val tabs = remember { ProntoResumeTabs.values() }
    val currentTitleId = remember {
        mutableStateOf(ProntoResumeTabs.PROFILE.title)
    }
    val onCurrentTitleChange: (titleId: Int) -> Unit = {
        currentTitleId.value = it
    }
    ProntoResumeTheme() {
        Scaffold(
            topBar = { ProntoResumeTopAppBar(currentTitleId) },
            bottomBar = {
                ProntoResumeBottomAppBar(
                    navController = navHostController,
                    tabs = tabs,
                    onTitleChange = onCurrentTitleChange
                )
            }
        ) { innerPadding ->
            NavGraph(
                navController = navHostController,
                paddingValues = innerPadding)
        }
    }
}

@Preview
@Composable
fun PreviewResumeApp() {
    ProntoResumeApp()
}