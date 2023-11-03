package com.tsarenko.langsapp.presentation.lesson

data class LessonState(
    var progress: Float = 0.1f,
    var isDialogShown: Boolean = false,
    var isDropDownMenuShown: Boolean = false,
    var isReportBottomSheetShown: Boolean = false,
    var reportDescription: String = "",
    var isThanksForTheReportDialogShown: Boolean = false
)
