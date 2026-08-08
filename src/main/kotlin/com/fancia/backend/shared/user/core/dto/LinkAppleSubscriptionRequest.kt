package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotBlank

data class LinkAppleSubscriptionRequest(
    @field:NotBlank(message = "originalTransactionId is required")
    val originalTransactionId: String,
    val productId: String? = null,
)
