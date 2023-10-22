package com.tsarenko.langsapp.presentation.registration

import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Interest
import com.tsarenko.langsapp.domain.model.Language

data class RegistrationState(
    var email: String = "",
    val isEmailValid: Boolean = false,
    val name: String = "",
    val language: String = "",
    val isLanguagePicked: Boolean = false,
    val availableLanguages: List<Language> = listOf(
        Language("Русский", R.drawable.russian_flag),
        Language("English", R.drawable.usa_flag),
        Language("Deutsch", R.drawable.german_flag),
        Language("Español", R.drawable.spanish_flag),
    ),
    val interests: List<Interest> = Interest.values().toList(),
    val areInterestsPicked: Boolean = false,
    val wordsPerDay: Int = 0
)
