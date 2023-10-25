package com.tsarenko.langsapp.presentation.lesson

sealed class LessonEvent {
    object OpenDialog : LessonEvent()
    object CloseDialog : LessonEvent()
}
