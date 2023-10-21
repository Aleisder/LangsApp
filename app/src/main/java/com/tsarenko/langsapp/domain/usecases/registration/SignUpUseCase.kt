package com.tsarenko.langsapp.domain.usecases.registration

import com.tsarenko.langsapp.domain.model.SignUpBody
import com.tsarenko.langsapp.domain.repository.LangsRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val langsRepository: LangsRepository
) {
    operator fun invoke(signUpBody: SignUpBody) {

    }
}