package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.user.core.enums.FriendshipRelationStatus
import java.util.UUID

data class FriendshipStatusResponse(
    val userId: UUID,
    val status: FriendshipRelationStatus,
    val friendshipId: UUID? = null,
)
