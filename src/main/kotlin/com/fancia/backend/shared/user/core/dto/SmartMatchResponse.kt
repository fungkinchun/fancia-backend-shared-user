package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime
import java.util.*

data class SmartMatchResponse(
    val id: UUID,
    val userId: UUID,
    val createdBy: UUID?,
    val matchedByUser: Boolean,
    val matchedByCreatedBy: Boolean,
    val createdAt: LocalDateTime?,
)
