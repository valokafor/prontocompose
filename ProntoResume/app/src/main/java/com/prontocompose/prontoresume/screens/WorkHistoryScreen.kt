package com.prontocompose.prontoresume.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.model.sampleWorkHistories
import com.prontocompose.prontoresume.screens.component.BodyBold
import com.prontocompose.prontoresume.screens.component.TitleH2
import com.prontocompose.prontoresume.screens.component.WorkHistoryItem
import com.prontocompose.prontoresume.ui.theme.Colors

@Composable
fun WorkHistoryScreen(){
    val workHistories = remember { sampleWorkHistories() }


    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 15.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {

        item {
            ProfileWork(
                profileName = stringResource(R.string.sample_title),
                title = stringResource(R.string.sample_title)
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        itemsIndexed(workHistories) { index, item ->
            WorkHistoryItem(
                item = item,
                isLastItem = index == workHistories.lastIndex
            )
        }
    }
}

@Composable
private fun ProfileWork(profileName: String, title: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = Colors.CardBackground,
                shape = RoundedCornerShape(24.dp))
            .padding(horizontal = 18.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.sample_headshot_100),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.clip(CircleShape))

        Column(Modifier.padding(start = 15.dp)) {
            TitleH2(modifier = Modifier, text = profileName)
            Spacer(Modifier.width(8.dp))

            BodyBold(modifier = Modifier, text = title)
        }
    }
}

@Preview
@Composable
fun PreviewWorkHistory() {
    WorkHistoryScreen()
}
