package com.tsarenko.langsapp.presentation.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsarenko.langsapp.R

@Composable
fun YourInterestsScreen(
    interests: List<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.your_interests)
        )
    }

    // TODO: FlowRow with chips

}

@Preview
@Composable
fun YourInterestScreenPreview() {
    YourInterestsScreen(
        interests = listOf(
            "Sports",
            "Travelling",
            "Art",
            "Films",
            "Games",
            "Financials",
            "Programming"
        )
    )
}