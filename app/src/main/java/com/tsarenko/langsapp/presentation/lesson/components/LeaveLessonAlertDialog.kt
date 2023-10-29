package com.tsarenko.langsapp.presentation.lesson.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tsarenko.langsapp.R

@Composable
fun LeaveLessonAlertDialog(
    onDismissClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismissClick() },
        confirmButton = {
            Text(
                text = stringResource(id = R.string.quit),
                modifier = Modifier.clickable { onConfirmClick() }
            )
        },
        dismissButton = {
            Text(
                text = stringResource(id = R.string.stay),
                modifier = Modifier.clickable {
                    onDismissClick()
                }
            )
        },
        title = {
            Text(text = stringResource(id = R.string.are_you_sure_you_want_to_quit))
        },
        text = {
            Text(text = stringResource(id = R.string.your_progress_will_be_lost))
        }
    )
}