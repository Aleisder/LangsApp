package com.tsarenko.langsapp.presentation.lesson

data class LessonState(
    val progress: Float = 0.1f,
    var isDialogShown: Boolean = false
)
