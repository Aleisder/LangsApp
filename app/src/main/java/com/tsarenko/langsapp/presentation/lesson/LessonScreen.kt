package com.tsarenko.langsapp.presentation.lesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tsarenko.langsapp.R

@Composable
fun LessonScreen(
    state: LessonState,
    onEvent: (LessonEvent) -> Unit
) {
    when {
        state.isDialogShown -> {
            AlertDialog(
                onDismissRequest = { onEvent(LessonEvent.CloseDialog) },
                confirmButton = {
                    Text(text = stringResource(id = R.string.quit))
                },
                dismissButton = {
                    Text(text = stringResource(id = R.string.stay))
                },
                title = {
                    Text(text = stringResource(id = R.string.are_you_sure_you_want_to_quit))
                },
                text = {
                    Text(text = stringResource(id = R.string.your_progress_will_be_lost))
                }
            )
        }
    }


    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = null
                )
            }

            LinearProgressIndicator(
                progress = state.progress
            )

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }


        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LessonScreenPreview() {
    val viewModel = hiltViewModel<LessonViewModel>()
    val state by viewModel.state.collectAsState()

    LessonScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}