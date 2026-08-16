package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.user.core.enums.FriendshipStatus
import java.time.LocalDateTime
import java.util.UUID

data class FriendshipResponse(
    val id: UUID,
    val requesterId: UUID,
    val addresseeId: UUID,
    val status: FriendshipStatus,
    val respondedAt: LocalDateTime?,
    val createdAt: LocalDateTime?,
)
