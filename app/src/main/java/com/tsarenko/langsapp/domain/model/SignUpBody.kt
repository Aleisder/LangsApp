package com.tsarenko.langsapp.domain.model

data class SignUpBody(
    val name: String,
    val email: String,
    val language: String,
    val interests: List<String>,
    val wordsPerDay: Int
)
