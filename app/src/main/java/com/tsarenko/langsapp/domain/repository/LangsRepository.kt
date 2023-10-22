package com.tsarenko.langsapp.domain.repository

import com.tsarenko.langsapp.domain.model.SignUpBody
import com.tsarenko.langsapp.domain.model.Syllabus

interface LangsRepository {
    suspend fun signUp(signUpBody: SignUpBody): Syllabus
}