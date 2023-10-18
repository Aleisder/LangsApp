package com.tsarenko.langsapp.data.repository

import com.tsarenko.langsapp.data.remote.LangsApi
import com.tsarenko.langsapp.domain.repository.LangsRepository
import com.tsarenko.langsapp.domain.model.SignUpBody
import com.tsarenko.langsapp.presentation.syllabus.Syllabus

class LangsRepositoryImpl(private val api: LangsApi) : LangsRepository {

    override suspend fun signUp(signUpBody: SignUpBody): Syllabus {
        return api.signUp(signUpBody)
    }

}