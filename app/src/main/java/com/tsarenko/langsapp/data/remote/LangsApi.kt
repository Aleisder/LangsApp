package com.tsarenko.langsapp.data.remote

import com.tsarenko.langsapp.presentation.registration.SignUpBody
import retrofit2.http.Body
import retrofit2.http.GET

interface LangsApi {

    @GET("/test")
    suspend fun getTest(): String

    @GET("/signup")
    suspend fun signUp(@Body signUpBody: SignUpBody)

    @GET("/signup/verify")
    suspend fun verifyCode(code: String)


}