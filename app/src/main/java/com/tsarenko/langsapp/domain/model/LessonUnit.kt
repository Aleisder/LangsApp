package com.tsarenko.langsapp.domain.model

sealed class LessonUnit {

    class QuestionUnit(
        val question: String,
        val answers: List<String>,
        val correctAnswer: String
    ) : LessonUnit()

    class GrammarUnit(
        val newWord: String
    )
}
