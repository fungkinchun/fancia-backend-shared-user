package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime
import java.util.UUID

data class GrantReferralPremiumRequest(
    val userId: UUID,
    val days: Long = 30,
)

data class GrantReferralPremiumResponse(
    val userId: UUID,
    val premiumActive: Boolean,
    val premiumExpiresAt: LocalDateTime?,
)
