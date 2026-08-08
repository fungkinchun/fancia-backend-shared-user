package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotBlank

data class LinkGoogleSubscriptionRequest(
    @field:NotBlank(message = "purchaseToken is required")
    val purchaseToken: String,
    val productId: String? = null,
)
