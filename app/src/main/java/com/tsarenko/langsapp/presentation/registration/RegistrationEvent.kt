package com.tsarenko.langsapp.presentation.registration

import com.tsarenko.langsapp.domain.model.Language

sealed interface RegistrationEvent {
    data class SetEmail(val email: String) : RegistrationEvent
    data class SelectLanguage(val language: Language) : RegistrationEvent
    data class OnInterestClick(val interest: String) : RegistrationEvent
    object SignUp : RegistrationEvent
}