package com.tsarenko.langsapp.presentation.registration.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Language
import com.tsarenko.langsapp.presentation.registration.RegistrationEvent
import com.tsarenko.langsapp.presentation.registration.RegistrationState
import com.tsarenko.langsapp.ui.theme.Blue500
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.util.Constants
import com.tsarenko.langsapp.util.HorizontalSpacer
import com.tsarenko.langsapp.util.NextButton
import com.tsarenko.langsapp.util.Route
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun LanguageScreen(
    navController: NavController,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = stringResource(id = R.string.select_language),
            style = MaterialTheme.typography.bodyLarge
        )

        VerticalSpacer(25)

        LanguageList(
            languages = Constants.availableLanguages,
            state,
            onEvent,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = {
                navController.navigate(Route.INTERESTS)
            },
            enabled = state.language != null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LanguageListItem(
    language: Language,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    val backgroundColor = if (language == state.language) Blue500 else MaterialTheme.colorScheme.background
    Card(
        modifier = Modifier.fillMaxWidth().background(backgroundColor),
        shape = RoundedCornerShape(25.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .clickable {
                    onEvent(RegistrationEvent.SelectLanguage(language))
                }

        ) {
            Image(
                painter = painterResource(language.icon),
                contentDescription = null
            )
            HorizontalSpacer(15)
            Text(
                text = language.name,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}

@Composable
fun LanguageList(
    languages: List<Language>,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
    ) {
        items(languages) { language ->
            LanguageListItem(language, state, onEvent)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun NativeLanguageScreenPreview() {
    LangsAppTheme {
        LanguageScreen(
            navController = rememberNavController(),
            state = RegistrationState(),
            onEvent = hiltViewModel()
        )
    }
}