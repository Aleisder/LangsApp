package com.tsarenko.langsapp.presentation.home

import com.tsarenko.langsapp.domain.model.Chapter
import com.tsarenko.langsapp.domain.model.Lesson

data class HomeState(
    val chapters: List<Chapter> = listOf(
        Chapter(
            number = 0,
            title = "Basics",
            lessons = listOf(
                Lesson(0, "Hello", "R.drawable.hello_lesson_preview", false),
                Lesson(1, "How are you?", "R.drawable.hello_lesson_preview", false),
                Lesson(2, "My name is", "R.drawable.hello_lesson_preview", false),
                Lesson(3, "Hello", "R.drawable.hello_lesson_preview", false),
                Lesson(4, "Hello", "R.drawable.hello_lesson_preview", false),
                Lesson(5, "Hello", "R.drawable.hello_lesson_preview", false),
                Lesson(6, "Hello", "R.drawable.hello_lesson_preview", false),
                Lesson(7, "Hello", "R.drawable.hello_lesson_preview", false),
            )
        )
    )
)
