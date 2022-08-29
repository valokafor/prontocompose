package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.prontocompose.prontoresume.model.WorkHistory
import com.prontocompose.prontoresume.ui.theme.Colors
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun WorkHistoryItem(item: WorkHistory, isLastItem: Boolean = false) {
    var expanded by remember { mutableStateOf(true) }

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (refLogo, refTitle, refEmployerName, refContent,
            refExpand, refLanguage, refDate, refLine, refSpacer) = createRefs()

        Icon(
            modifier = Modifier
                .constrainAs(refLogo) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    width = Dimension.value(38.dp)
                    height = Dimension.value(38.dp)
                }
                .border(
                    width = 1.dp,
                    color = Colors.Blue_3,
                    shape = CircleShape
                )
                .padding(10.dp),
            painter = painterResource(item.logoId),
            contentDescription = null,
            tint = Color.Unspecified
        )

        if (!isLastItem) {
            Divider(
                modifier = Modifier
                    .constrainAs(refLine) {
                        start.linkTo(refLogo.start)
                        end.linkTo(refLogo.end)
                        top.linkTo(refLogo.bottom)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
                    .width(1.dp),
                color = Colors.Blue_3
            )
        }

        Body(
            modifier = Modifier
                .constrainAs(refTitle) {
                    start.linkTo(refLogo.end, margin = 12.dp)
                    top.linkTo(refLogo.top)
                },
            text = item.companyName
        )

        Icon(
            imageVector = if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
            tint = Colors.Secondary_3,
            contentDescription = null,
            modifier = Modifier
                .constrainAs(refExpand) {
                    end.linkTo(parent.end)
                    top.linkTo(refLogo.top)
                }
                .clickable { expanded = !expanded }
        )

        TitleH2(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 8.dp)
                .constrainAs(refEmployerName) {
                    start.linkTo(refTitle.start)
                    top.linkTo(refTitle.bottom)
                },
            text = item.position
        )

        if (expanded) {
            Body(
                modifier = Modifier
                    .constrainAs(refContent) {
                        start.linkTo(refTitle.start)
                        top.linkTo(refEmployerName.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }, text = item.summary
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(refLanguage) {
                        start.linkTo(refContent.start)
                        top.linkTo(refContent.bottom, 12.dp)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                items(item.skills) {
                    LanguageText(modifier = Modifier, text = it.name)
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(refDate) {
                        start.linkTo(refLanguage.start)
                        top.linkTo(refLanguage.bottom, 12.dp)
                        width = Dimension.fillToConstraints
                    },
                text = "${item.startDate} - ${item.endDate}",
                color = Colors.Secondary_5,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                fontFamily = poppins
            )
        }
    }


}