package com.tsarenko.langsapp.util

import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Chapter
import com.tsarenko.langsapp.domain.model.Language
import com.tsarenko.langsapp.domain.model.Lesson
import com.tsarenko.langsapp.domain.model.Syllabus

object Constants {

    val availableLanguages = listOf(
        Language("Русский", R.drawable.russian_flag),
        Language("English", R.drawable.usa_flag),
        Language("Deutsch", R.drawable.german_flag),
        Language("Español", R.drawable.spanish_flag),
    )

    val MOCK_SYLLABUS = Syllabus(
        id = "235047",
        chapters = listOf(
            Chapter(
                number = 0,
                title = "Basics",
                lessons = listOf(
                    Lesson(0, "Hello", "R.drawable.hello_lesson_preview", true),
                    Lesson(1, "How are you?", "R.drawable.hello_lesson_preview", true),
                    Lesson(2, "My name is", "R.drawable.hello_lesson_preview", true),
                    Lesson(3, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(4, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(5, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(6, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(7, "Hello", "R.drawable.hello_lesson_preview", false)
                )
            ),
            Chapter(
                number = 2,
                title = "Numbers",
                lessons = listOf(
                    Lesson(0, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(1, "How are you?", "R.drawable.hello_lesson_preview", false),
                    Lesson(2, "My name is", "R.drawable.hello_lesson_preview", false),
                    Lesson(3, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(4, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(5, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(6, "Hello", "R.drawable.hello_lesson_preview", false),
                    Lesson(7, "Hello", "R.drawable.hello_lesson_preview", false)
                )
            )
        )
    )
}