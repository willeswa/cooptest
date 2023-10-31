package com.wanjala.cooptest.data.service

import com.wanjala.cooptest.data.models.AuthBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/login")
    suspend fun login(@Body authBody: AuthBody)
    
}