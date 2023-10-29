package com.tsarenko.langsapp.presentation.lesson

sealed class LessonEvent {
    object OpenDialog : LessonEvent()
    object CloseDialog : LessonEvent()
    object ShowDropDownMenu : LessonEvent()
    object HideDropDownMenu : LessonEvent()
    object ShowReportModalSheet : LessonEvent()
    object HideReportModalSheet : LessonEvent()
}
