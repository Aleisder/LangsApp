package com.tsarenko.langsapp.domain.usecases.lesson

import com.tsarenko.langsapp.domain.repository.LangsRepository
import javax.inject.Inject

class GetLessonUseCase @Inject constructor(
    private val langsRepository: LangsRepository
) {
    operator fun invoke() {

    }
}