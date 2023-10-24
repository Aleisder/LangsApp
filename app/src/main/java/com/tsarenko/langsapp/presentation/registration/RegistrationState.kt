package com.tsarenko.langsapp.presentation.registration

import com.tsarenko.langsapp.domain.model.Language
import com.tsarenko.langsapp.domain.model.SignUpBody

data class RegistrationState(
    var email: String = "",
    val isEmailValid: Boolean = false,
    val name: String = "",
    val language: Language? = null,
    val interests: MutableList<String> = mutableListOf(),
    val wordsPerDay: Int = 0
) {
    fun toSignUpBody() : SignUpBody {
        return SignUpBody(
            name = name,
            email = email,
            language = language!!.name,
            interests = interests,
            wordsPerDay = wordsPerDay
        )
    }
}
