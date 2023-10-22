package com.tsarenko.langsapp.data.remote

import com.tsarenko.langsapp.domain.model.SignUpBody
import com.tsarenko.langsapp.domain.model.Syllabus
import retrofit2.http.Body
import retrofit2.http.GET

interface LangsApi {

    @GET("/signup")
    suspend fun signUp(@Body signUpBody: SignUpBody): Syllabus

}