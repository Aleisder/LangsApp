package com.tsarenko.langsapp.presentation.lesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.presentation.lesson.components.LeaveLessonAlertDialog
import com.tsarenko.langsapp.util.Graph

@Composable
fun LessonScreen(
    navController: NavController,
    state: LessonState,
    onEvent: (LessonEvent) -> Unit
) {
    when {
        state.isDialogShown -> {
            LeaveLessonAlertDialog(
                onDismissClick = { onEvent(LessonEvent.CloseDialog) },
                onConfirmClick = { navController.navigate(Graph.HOME) }
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
                onClick = { onEvent(LessonEvent.OpenDialog) }
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
        navController = rememberNavController(),
        state = state,
        onEvent = viewModel::onEvent
    )
}