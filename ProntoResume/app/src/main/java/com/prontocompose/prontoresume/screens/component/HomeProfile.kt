package com.prontocompose.prontoresume.screens.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.ui.theme.Colors


@Composable
fun HomeProfile(modifier: Modifier, name: String, title: String) {
    val confirmMessageDialog = remember { mutableStateOf(false)  }
    val confirmCallDialog = remember { mutableStateOf(false)  }
    val context = LocalContext.current

    ConstraintLayout(modifier = modifier) {
        val (content, avatar) = createRefs()
        Column( modifier = Modifier
            .constrainAs(content) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(avatar.top, margin = 45.dp)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            .background(
                color = Colors.CardBackground,
                shape = RoundedCornerShape(24.dp)
            )
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
                    onClick = {confirmMessageDialog.value = true}
                )

                AppButton(modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.call),
                    onClick = {confirmCallDialog.value = true}
                )
            }
            if (confirmMessageDialog.value) {
                ConfirmationDialog(
                    message = "Send Message to $name",
                    onDismiss = {confirmMessageDialog.value = false}) {
                    val fakeNumber = "8884561234"
                    val smsIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.fromParts("sms", fakeNumber, null))
                    context.startActivity(smsIntent)
                }
            }

            if (confirmCallDialog.value) {
                ConfirmationDialog(
                    message = "Make phone call to $name",
                    onDismiss = {confirmCallDialog.value = false}) {
                    val fakeNumber = "8884561234"
                    val callIntent = Intent(
                        Intent.ACTION_DIAL,
                        Uri.fromParts("tel", fakeNumber, null))
                    context.startActivity(callIntent)
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.sample_headshot_100),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .constrainAs(avatar) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    width = Dimension.value(90.dp)
                    height = Dimension.value(90.dp)
                }
        )
    }
}