package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.ui.theme.Colors
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun SkillSummary(modifier: Modifier = Modifier, description: String) {

    var expanded by remember { mutableStateOf(true) }

    ConstraintLayout(modifier = modifier) {
        val (icon, title, content, arrow) = createRefs()

        Icon(
            modifier = Modifier
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(
                    color = Colors.Blue_2,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(10.dp),
            painter = painterResource(
                id = R.drawable.ic_baseline_sticky_note_2_24),
            tint = Color.Unspecified,
            contentDescription = null
        )

        SubTitle(
            modifier = Modifier.constrainAs(title) {
                    top.linkTo(icon.top)
                    bottom.linkTo(icon.bottom)
                    start.linkTo(icon.end, margin = 16.dp)
                    end.linkTo(arrow.start)
                    width = Dimension.fillToConstraints
                },
            text = stringResource(R.string.skill_summary)
        )

        Icon(
            modifier = Modifier
                .constrainAs(arrow) {
                    top.linkTo(icon.top)
                    bottom.linkTo(icon.bottom)
                    end.linkTo(parent.end) }
                .clickable { expanded = !expanded },
            imageVector = if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
            contentDescription = "",
            tint = Colors.Secondary_3
        )

        if (expanded) {
            Body(
                modifier = Modifier
                    .constrainAs(content) {
                        top.linkTo(icon.bottom)
                        start.linkTo(title.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                text = description
            )
        }
    }
}