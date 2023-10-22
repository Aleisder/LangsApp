package com.tsarenko.langsapp.presentation.registration

import com.tsarenko.langsapp.domain.model.Interest

sealed interface RegistrationEvent {
    data class SetEmail(val email: String) : RegistrationEvent
    data class ChooseLanguage(val language: String) : RegistrationEvent
    data class SelectInterest(val interest: Interest) : RegistrationEvent
    data class UnselectInterest(val interest: Interest) : RegistrationEvent
}