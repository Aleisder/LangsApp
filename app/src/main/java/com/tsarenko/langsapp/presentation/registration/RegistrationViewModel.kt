package com.tsarenko.langsapp.presentation.registration

import androidx.lifecycle.ViewModel
import com.tsarenko.langsapp.domain.repository.LangsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    langsRepository: LangsRepository
) : ViewModel() {

    fun continueWithGoogle() {
        // TODO: 
    }

    fun continueWithFacebook() {
        // TODO:
    }
    
    fun createAccount() {
        // TODO:  
    }
}