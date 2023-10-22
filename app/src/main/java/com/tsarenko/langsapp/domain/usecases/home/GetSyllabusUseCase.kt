package com.tsarenko.langsapp.domain.usecases.home

import com.tsarenko.langsapp.domain.repository.LangsRepository
import javax.inject.Inject

class GetSyllabusUseCase @Inject constructor(
    private val langsRepository: LangsRepository
) {
    operator fun invoke() {

    }
}