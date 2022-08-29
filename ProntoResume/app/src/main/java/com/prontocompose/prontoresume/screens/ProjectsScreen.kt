package com.prontocompose.prontoresume.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prontocompose.prontoresume.model.sampleProjects
import com.prontocompose.prontoresume.screens.component.ProjectItem

@Composable
fun ProjectsScreen(){
    val projects = remember { sampleProjects() }
    LazyColumn(
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(projects) {
            ProjectItem(
                project = it,
                onDownload = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewProjectScreen() {
    ProjectsScreen()
}
