package com.wanjala.cooptest.data.models

import com.google.gson.annotations.SerializedName


data class AuthBody(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)
