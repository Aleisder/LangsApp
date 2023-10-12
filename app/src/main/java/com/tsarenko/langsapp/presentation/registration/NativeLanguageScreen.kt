package com.tsarenko.langsapp.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.util.HorizontalSpacer
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun NativeLanguageScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ) {
        Text(
            text = stringResource(id = R.string.what_your_native_language),
            style = MaterialTheme.typography.titleLarge
        )

        VerticalSpacer(10)
        
        Text(
            text = stringResource(id = R.string.native_language_description),
            textAlign = TextAlign.Center
        )

        VerticalSpacer(10)

        val languages = listOf(
            Language("Русский", R.drawable.russian_flag),
            Language("English", R.drawable.usa_flag),
            Language("Deutsch", R.drawable.german_flag),
            Language("Español", R.drawable.spanish_flag),
        )

        LanguageList(languages = languages)

    }
}

@Composable
fun LanguageListItem(language: Language) {
    Row(
        verticalAlignment = Alignment.CenterVertically
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

@Composable
fun LanguageList(languages: List<Language>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(languages) {language ->
            LanguageListItem(language)
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun NativeLanguageScreenPreview() {
    LangsAppTheme {
        NativeLanguageScreen()
    }
}