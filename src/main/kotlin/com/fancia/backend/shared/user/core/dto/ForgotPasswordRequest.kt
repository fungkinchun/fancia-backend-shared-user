package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.Email

data class ForgotPasswordRequest(
    val email: @Email String? = "",
)