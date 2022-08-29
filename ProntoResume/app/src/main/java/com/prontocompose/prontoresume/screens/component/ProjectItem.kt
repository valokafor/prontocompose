package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.model.Project
import com.prontocompose.prontoresume.ui.theme.Colors

@Composable
fun ProjectItem(project: Project, onDownload: () -> Unit) {
    var favorite by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .background(
                color = Colors.Secondary_4,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(18.dp)
            .fillMaxWidth()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(9.dp))
                    .padding(10.dp),
                imageVector = project.appLogo,
                contentDescription = null,
                tint = MaterialTheme.colors.secondary
            )

            SubTitle(modifier = Modifier.padding(start = 12.dp), text = project.name)

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Rounded.Favorite,
                contentDescription = null,
                modifier = Modifier.clickable { favorite = !favorite},
                tint = if (favorite) Colors.Pink else Colors.Secondary_6
            )
        }

        Body(
            modifier = Modifier.padding(top = 13.dp),
            text = project.description
        )

        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            AppOutlinedButton(
                radius = 21.dp,
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                modifier = Modifier
                    .padding(top = 10.dp),
                text = stringResource(R.string.download),
                onClick = onDownload
            )
        }
    }
}