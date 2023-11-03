package com.tsarenko.langsapp.domain.model

data class IssueReport(
    val errorType: ErrorType,
    val description: String
)
