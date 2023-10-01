package com.tsarenko.langsapp.data.repository

import com.tsarenko.langsapp.data.remote.LangsApi
import javax.inject.Inject

class LangsRepository @Inject constructor(private val api: LangsApi) {

    suspend fun getTest(): String {
        return api.getTest()
    }

 }