package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.prontocompose.prontoresume.navigation.ProntoResumeTabs
import com.prontocompose.prontoresume.ui.theme.Colors
import com.prontocompose.prontoresume.ui.theme.poppinsFont
import java.util.*

@Composable
fun ProntoResumeTopAppBar(titleId: State<Int>) {
    Column {
        Text(
            text = stringResource(id = titleId.value),
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
fun ProntoResumeBottomAppBar(
    navController: NavController,
    tabs: Array<ProntoResumeTabs>,
    onTitleChange: (Int) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: ProntoResumeTabs.PROFILE.route

    BottomNavigation(
        Modifier.windowInsetsBottomHeight(
            WindowInsets.navigationBars.add(WindowInsets(bottom = 56.dp)))
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                label = { Text(stringResource(tab.title).uppercase(Locale.getDefault())) },
                selected = currentRoute == tab.route,
                onClick = {
                    if (tab.route != currentRoute) {
                        navController.navigate(tab.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        onTitleChange(tab.title)
                    }
                },
                alwaysShowLabel = false,
                selectedContentColor = Color(0xFF376EFB),
                unselectedContentColor = Color(0xFFA9A9A9),
                modifier = Modifier
                    .navigationBarsPadding()
                    .background(Color(0xFFFAFAFA))
            )
        }
    }
}