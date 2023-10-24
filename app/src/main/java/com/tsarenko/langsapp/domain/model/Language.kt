package com.tsarenko.langsapp.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

data class Language(
    val name: String,
    @DrawableRes val icon: Int,
    var selected: Boolean = false
)
