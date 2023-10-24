package com.tsarenko.langsapp.presentation.registration.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.presentation.registration.RegistrationEvent
import com.tsarenko.langsapp.presentation.registration.RegistrationState
import com.tsarenko.langsapp.ui.theme.Blue500
import com.tsarenko.langsapp.util.Graph
import com.tsarenko.langsapp.util.NextButton
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun WordsPerDayScreen(
    navController: NavController,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.how_many_words_per_day),
        )

        VerticalSpacer(80)

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            for(i in listOf(5, 10, 15)) {
                AmountCell(
                    amount = i,
                    state = state,
                    onEvent = onEvent
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = { navController.navigate(Graph.HOME) },
            enabled = state.wordsPerDay != 0,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AmountCell(
    amount: Int,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = if (state.wordsPerDay == amount) Blue500 else MaterialTheme.colorScheme.background,
        border = BorderStroke(4.dp, Blue500),
        modifier = Modifier
            .size(60.dp)
            .clickable { onEvent(RegistrationEvent.SetWordsPerDay(amount)) },
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = amount.toString(),
                fontSize = 30.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}
