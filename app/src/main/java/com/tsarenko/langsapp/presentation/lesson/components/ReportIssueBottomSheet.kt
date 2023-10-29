package com.tsarenko.langsapp.presentation.lesson.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tsarenko.langsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportIssueBottomSheet(
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() }
    ) {
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(id = R.string.send_report))
        }
        
    }
}