package com.tsarenko.langsapp.presentation.registration

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
import com.tsarenko.langsapp.domain.model.Interest
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

        FlowRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            state.interests.forEach {
                InterestChip(
                    interest = it,
                    onEvent = onEvent
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = { navController.navigate(Route.Screen.wordsPerDay) },
            enabled = state.areInterestsPicked,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestChip(
    interest: Interest,
    onEvent: (RegistrationEvent) -> Unit
) {
    FilterChip(
        selected = interest.isSelected(),
        onClick = {
            if (interest.isSelected()) onEvent(RegistrationEvent.UnselectInterest(interest))
            else onEvent(RegistrationEvent.SelectInterest(interest))
        },
        shape = RoundedCornerShape(15.dp),
        label = {
            Text(
                text = interest.toString(),
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