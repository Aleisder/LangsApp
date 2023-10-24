package com.tsarenko.langsapp.presentation.registration.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.presentation.registration.RegistrationEvent
import com.tsarenko.langsapp.presentation.registration.RegistrationState
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.util.NextButton
import com.tsarenko.langsapp.util.Route
import com.tsarenko.langsapp.util.VerticalSpacer

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterestsScreen(
    navController: NavController,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.your_interests),
            style = MaterialTheme.typography.titleLarge
        )

        VerticalSpacer(height = 25)

        val interests = listOf(
            "Sports",
            "Travelling",
            "Art",
            "Movies",
            "Cartoons",
            "Games",
            "Financials",
            "Programming",
            "Music",
            "Literature",
            "Science"
        )

        FlowRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            interests.forEach {
                InterestChip(
                    interest = it,
                    onEvent = onEvent
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = { navController.navigate(Route.WORDS_PER_DAY) },
            enabled = state.interests.isEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestChip(
    interest: String,
    onEvent: (RegistrationEvent) -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = {
            onEvent(RegistrationEvent.OnInterestClick(interest))
            selected = !selected
        },
        shape = RoundedCornerShape(15.dp),
        label = {
            Text(
                text = interest,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun YourInterestScreenPreview() {
    InterestsScreen(
        navController = rememberNavController(),
        state = RegistrationState(),
        onEvent = hiltViewModel()
    )
}