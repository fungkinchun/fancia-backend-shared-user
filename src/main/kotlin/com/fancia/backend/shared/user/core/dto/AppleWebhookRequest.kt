package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotBlank

data class AppleWebhookRequest(
    @field:NotBlank(message = "signedPayload is required")
    val signedPayload: String,
)
