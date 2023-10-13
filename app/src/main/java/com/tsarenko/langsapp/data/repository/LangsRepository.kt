package com.tsarenko.langsapp.data.repository

import com.tsarenko.langsapp.data.remote.LangsApi

class LangsRepository(private val api: LangsApi) {

    suspend fun getTest(): String {
        return api.getTest()
    }

 }