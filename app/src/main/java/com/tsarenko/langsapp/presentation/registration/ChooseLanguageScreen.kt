package com.tsarenko.langsapp.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Language
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.util.HorizontalSpacer
import com.tsarenko.langsapp.util.NextButton
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun ChooseLanguageScreen() {
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

        val languages = listOf(
            Language("Русский", R.drawable.russian_flag),
            Language("English", R.drawable.usa_flag),
            Language("Deutsch", R.drawable.german_flag),
            Language("Español", R.drawable.spanish_flag),
        )

        LanguageList(
            languages = languages,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LanguageListItem(language: Language) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)

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
    modifier: Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
    ) {
        items(languages) { language ->
            LanguageListItem(language)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun NativeLanguageScreenPreview() {
    LangsAppTheme {
        ChooseLanguageScreen()
    }
}