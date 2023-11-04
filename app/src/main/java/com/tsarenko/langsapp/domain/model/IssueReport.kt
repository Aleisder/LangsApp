package com.tsarenko.langsapp.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class IssueReport(
    val errorType: ErrorType,
    val description: String
)
