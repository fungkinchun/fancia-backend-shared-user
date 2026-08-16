package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class CreateFriendRequest(
    @field:NotNull(message = "User id is required")
    val userId: UUID,
)
