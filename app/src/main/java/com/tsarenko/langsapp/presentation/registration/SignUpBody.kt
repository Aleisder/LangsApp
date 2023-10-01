package com.tsarenko.langsapp.presentation.registration

data class SignUpBody(
    val name: String,
    val email: String,
    val nativeLanguage: String,
    val learningLanguage: String
)
