package com.tsarenko.langsapp.presentation.lesson.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tsarenko.langsapp.R

@Composable
fun ThanksForTheReportDialog(
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = null
            )
        },
        title = {
            Text(text = stringResource(id = R.string.thanks_for_your_feedback))
        },
        text = {
            Text(text = stringResource(id = R.string.every_report_helps))
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            Button(
                onClick = { onDismissRequest() }
            ) {
                Text(text = stringResource(R.string.got_it))
            }
        }
    )
}