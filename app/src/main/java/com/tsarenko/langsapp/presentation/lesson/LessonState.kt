package com.tsarenko.langsapp.presentation.lesson

import com.tsarenko.langsapp.domain.model.LessonUnit

data class LessonState(
    var progress: Float = 0.1f,
    var currentUnit: LessonUnit,
    var isDialogShown: Boolean = false,
    var isDropDownMenuShown: Boolean = false,
    var isReportBottomSheetShown: Boolean = false,
    var reportDescription: String = "",
    var isThanksForTheReportDialogShown: Boolean = false
)
