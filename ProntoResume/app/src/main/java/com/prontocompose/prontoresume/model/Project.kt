package com.prontocompose.prontoresume.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

data class Project(
    val name: String,
    val description: String,
    val appLogo: ImageVector,
    val favorite: Boolean = false
)

fun sampleProjects() = listOf(
    Project(
        name ="Pronto Resume",
        description = "This is your own resume app. This Resume app allows you" +
                "to showcase the list of apps that you have built. As you go " +
                "through the course you can add to this list as you complete them",
        appLogo = Icons.Rounded.Person,
        favorite = false,
    ),
    Project(
        name = "Pronto Notepad",
        description = "This app allows users to add unlimited notes/journals and categories. " +
                "Each note is assigned to a Category. Users can add an image to a Note.",
        appLogo = Icons.Rounded.Edit,
        favorite = false,
    ),
    Project(
        name = "Pronto Todo",
        description = "Todo List Apps are the most common app used to learn programming skills, " +
                "no other app comes close. By completing this app you will learn the skills " +
                "to build any reminder-based app",
        appLogo = Icons.Rounded.CheckCircle,
        favorite = false
    )
)