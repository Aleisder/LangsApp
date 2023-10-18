package com.tsarenko.langsapp.domain.repository

import com.tsarenko.langsapp.domain.model.SignUpBody
import com.tsarenko.langsapp.presentation.syllabus.Syllabus

interface LangsRepository {
    suspend fun signUp(signUpBody: SignUpBody): Syllabus
}