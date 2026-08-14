package com.fancia.backend.shared.user.core.dto

import java.time.LocalDateTime
import java.util.UUID

data class SmartMatchResponse(
    val id: UUID,
    val firstUserId: UUID,
    val secondUserId: UUID,
    val firstUserLiked: Boolean?,
    val secondUserLiked: Boolean?,
    val firstUserLikedAt: LocalDateTime?,
    val secondUserLikedAt: LocalDateTime?,
    val rank: Int? = null,
    val score: Double? = null,
    val createdAt: LocalDateTime?,
)
