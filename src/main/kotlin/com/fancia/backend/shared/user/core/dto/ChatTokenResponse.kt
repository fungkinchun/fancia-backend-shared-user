package com.fancia.backend.shared.user.core.dto

data class ChatTokenResponse(
    val apiKey: String,
    val token: String,
    val userId: String,
)
