package com.tsarenko.langsapp.util

import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Language

object Constants {

    val availableLanguages = listOf(
        Language("Русский", R.drawable.russian_flag),
        Language("English", R.drawable.usa_flag),
        Language("Deutsch", R.drawable.german_flag),
        Language("Español", R.drawable.spanish_flag),
    )
}