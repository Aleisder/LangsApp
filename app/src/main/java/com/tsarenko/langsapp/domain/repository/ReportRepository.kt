package com.tsarenko.langsapp.domain.repository

import com.tsarenko.langsapp.domain.model.IssueReport

interface ReportRepository {
    suspend fun sendReport(issueReport: IssueReport)
}