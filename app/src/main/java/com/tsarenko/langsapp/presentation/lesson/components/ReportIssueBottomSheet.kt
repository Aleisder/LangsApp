package com.tsarenko.langsapp.presentation.lesson.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.presentation.lesson.LessonEvent
import com.tsarenko.langsapp.presentation.lesson.LessonState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportIssueBottomSheet(
    onDismissRequest: () -> Unit,
    state: LessonState,
    onEvent: (LessonEvent) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            Text(text = stringResource(id = R.string.specify_error_type))

            OutlinedTextField(
                value = state.reportDescription,
                onValueChange = {
                    onEvent(LessonEvent.SetReportDescription(it))
                }
            )


            Button(
                onClick = {
                    onEvent(LessonEvent.SendReport)
                    onEvent(LessonEvent.ShowThanksForTheReportDialog)
                }
            ) {
                Text(text = stringResource(id = R.string.send_report))
            }
        }


    }
}