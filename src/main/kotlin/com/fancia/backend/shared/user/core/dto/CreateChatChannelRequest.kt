package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class CreateChatChannelRequest(
    @field:NotNull(message = "Other user id is required")
    val otherUserId: UUID,
)
