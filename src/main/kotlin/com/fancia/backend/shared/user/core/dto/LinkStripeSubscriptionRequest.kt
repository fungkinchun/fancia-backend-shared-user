package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotBlank

data class LinkStripeSubscriptionRequest(
    @field:NotBlank(message = "subscriptionId is required")
    val subscriptionId: String,
)
