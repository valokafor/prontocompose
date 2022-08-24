package com.prontocompose.prontoresume.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.prontocompose.prontoresume.R

enum class Destinations(val route: String) {
    Profile("profile"),
    Projects("project"),
    Work_History("work_history")
}

enum class ProntoResumeTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    PROFILE(R.string.profile, R.drawable.ic_user_8, Destinations.Profile.route),
    PROJECTS(R.string.projects, R.drawable.ic_add_plain, Destinations.Projects.route),
    WORK_HISTORY(R.string.work_history, R.drawable.ic_work_symbol, Destinations.Work_History.route)
}