package com.tsarenko.langsapp.presentation.home

import com.tsarenko.langsapp.domain.model.Syllabus
import com.tsarenko.langsapp.util.Constants

data class HomeState(
    val syllabus: Syllabus = Constants.MOCK_SYLLABUS
)
