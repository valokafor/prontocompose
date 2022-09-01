package com.prontocompose.prontoresume.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prontocompose.prontoresume.screens.ProfileScreen
import com.prontocompose.prontoresume.screens.ProjectsScreen
import com.prontocompose.prontoresume.screens.WorkHistoryScreen

@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Profile.route,
        modifier = Modifier.padding(paddingValues) ){

        composable(Destinations.Profile.route) {
            ProfileScreen()
        }

        composable(Destinations.Projects.route) {
            ProjectsScreen()
        }

        composable(Destinations.Work_History.route) {
            WorkHistoryScreen()
        }
    }
}