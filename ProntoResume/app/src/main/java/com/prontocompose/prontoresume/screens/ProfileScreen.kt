package com.prontocompose.prontoresume.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.screens.component.HomeProfile
import com.prontocompose.prontoresume.screens.component.SkillHighlight
import com.prontocompose.prontoresume.screens.component.SkillSummary

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        HomeProfile(
            modifier = Modifier.fillMaxWidth(),
            name = stringResource(R.string.sample_name),
            title = stringResource(R.string.sample_title),
        )
        SkillSummary(modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxWidth(),
            description = stringResource(R.string.sample_description)
        )
        SkillHighlight(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}