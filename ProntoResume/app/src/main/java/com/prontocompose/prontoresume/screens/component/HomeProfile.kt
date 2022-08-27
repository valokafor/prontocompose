package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.ui.theme.Colors

@Composable
fun HomeProfile(modifier: Modifier, name: String, title: String) {
    ConstraintLayout(modifier = modifier) {
        val (content, avatar) = createRefs()
        Column( modifier = Modifier
                .background(color = Colors.CardBackground,
                    shape = RoundedCornerShape(24.dp))
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleH2(
                modifier = Modifier.padding(top = 20.dp),
                text = name)

            BodyBold(modifier = Modifier, text = title)

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AppOutlinedButton(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.message),
                    onClick = {}
                )

                AppButton(modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.call),
                    onClick = {}
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.sample_headshot_100),
            contentDescription = "", contentScale = ContentScale.Crop
        )
    }
}