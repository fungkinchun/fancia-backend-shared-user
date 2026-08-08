package com.fancia.backend.shared.user.core.message

import com.fancia.backend.shared.user.core.enums.PaymentProvider
import com.fancia.backend.shared.user.core.enums.SubscriptionStatus
import java.time.LocalDateTime
import java.util.UUID

data class SubscriptionChangedEvent(
    val userId: UUID,
    val provider: PaymentProvider,
    val providerSubscriptionId: String,
    val productId: String?,
    val status: SubscriptionStatus,
    val premiumActive: Boolean,
    val expiresAt: LocalDateTime?,
)
