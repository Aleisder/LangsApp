package com.tsarenko.langsapp.presentation.lesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.presentation.lesson.components.LeaveLessonAlertDialog
import com.tsarenko.langsapp.presentation.lesson.components.ReportIssueBottomSheet
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

        state.isReportBottomSheetShown -> {
            ReportIssueBottomSheet(
                onDismissRequest = { onEvent(LessonEvent.HideReportModalSheet) }
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
                onClick = { onEvent(LessonEvent.ShowDropDownMenu) }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }

            DropdownMenu(
                expanded = state.isDropDownMenuShown,
                onDismissRequest = { onEvent(LessonEvent.HideDropDownMenu) }
            ) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(id = R.string.report_issue)) },
                    onClick = { onEvent(LessonEvent.ShowReportModalSheet) }
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