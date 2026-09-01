package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime
import java.util.UUID

data class ReferralResponse(
    val id: UUID,
    val refereeUserId: UUID,
    val referrerSlug: String,
    val rewardedAt: LocalDateTime,
)
