package com.tsarenko.langsapp.domain.model

data class Chapter(
    val number: Int,
    val title: String,
    val lessons: List<Lesson>
)
