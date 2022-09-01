package com.prontocompose.prontoresume.screens.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prontocompose.prontoresume.R
import com.prontocompose.prontoresume.navigation.ClickEvents

@Composable
fun ConfirmationDialog(
    message: String,
    onDismiss: () -> Unit,
    onPositiveButtonClicked: () -> Unit ) {

    AlertDialog(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.padding(0.dp),
        title = { Text(text = stringResource(id = R.string.are_you_sure)) },
        text = {
            Column {
                Text(message,
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
                content = {
                    Button(onClick = onDismiss) {
                        Text(
                            text = "Cancel",
                            color= MaterialTheme.colors.surface,
                            style = MaterialTheme.typography.button)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = onPositiveButtonClicked) {
                        Text(
                            text = "Yes",
                            color= MaterialTheme.colors.surface,
                            style = MaterialTheme.typography.button)
                    }
                })
        },
        onDismissRequest = {
            onDismiss()
        }
    )
}