package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime
import java.util.UUID

data class SmartMatchResponse(
    val id: UUID,
    val userId: UUID,
    val targetId: UUID,
    val userIdFlag: Boolean?,
    val targetIdFlag: Boolean?,
    val userIdFlagAt: LocalDateTime?,
    val targetIdFlagAt: LocalDateTime?,
    val rank: Int? = null,
    val score: Double? = null,
    val createdAt: LocalDateTime?,
)
