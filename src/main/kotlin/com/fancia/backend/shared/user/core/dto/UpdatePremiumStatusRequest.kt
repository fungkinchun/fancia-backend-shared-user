package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime

data class UpdatePremiumStatusRequest(
    val premiumActive: Boolean,
    val premiumExpiresAt: LocalDateTime? = null,
)
