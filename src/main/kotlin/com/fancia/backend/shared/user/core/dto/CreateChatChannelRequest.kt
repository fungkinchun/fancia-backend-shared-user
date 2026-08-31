package com.fancia.backend.shared.user.core.dto

import java.util.UUID

data class CreateChatChannelRequest(
    val otherUserId: UUID? = null,
    val eventId: UUID? = null,
)
