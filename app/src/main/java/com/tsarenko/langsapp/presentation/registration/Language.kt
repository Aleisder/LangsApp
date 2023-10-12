package com.tsarenko.langsapp.presentation.registration

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Language(
   val name: String,
   @DrawableRes val icon: Int
)
