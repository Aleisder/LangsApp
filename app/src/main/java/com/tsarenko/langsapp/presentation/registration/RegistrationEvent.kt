package com.tsarenko.langsapp.presentation.registration

sealed interface RegistrationEvent {
    data class SetEmail(val email: String) : RegistrationEvent
    data class ChooseLanguage(val language: String) : RegistrationEvent
}