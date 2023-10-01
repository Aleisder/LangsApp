package com.tsarenko.langsapp.data.remote

import retrofit2.http.GET

interface LangsApi {

    @GET("/test")
    suspend fun getTest(): String

}