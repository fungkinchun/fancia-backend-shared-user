package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.utils.Default
import com.fancia.backend.shared.user.core.enums.PaymentProvider
import com.fancia.backend.shared.user.core.enums.SubscriptionStatus
import java.time.LocalDateTime
import java.util.UUID

data class SubscriptionResponse @Default constructor(
    val id: UUID? = null,
    val userId: UUID? = null,
    val provider: PaymentProvider? = null,
    val providerSubscriptionId: String? = null,
    val productId: String? = null,
    val status: SubscriptionStatus? = null,
    val expiresAt: LocalDateTime? = null,
    val environment: String? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)
