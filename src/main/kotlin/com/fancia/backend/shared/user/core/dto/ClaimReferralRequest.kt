package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class ClaimReferralRequest(
    @field:NotBlank
    val referrerSlug: String,
)

data class ClaimReferralResponse(
    val referrerSlug: String,
    val premiumExpiresAt: LocalDateTime?,
    val premiumActive: Boolean,
)
