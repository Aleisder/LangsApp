package com.tsarenko.langsapp.presentation.syllabus

data class Chapter(
    val number: Int,
    val title: String,
    val lessons: List<Lesson>
)
