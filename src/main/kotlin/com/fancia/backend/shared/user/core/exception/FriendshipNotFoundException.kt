package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class FriendshipNotFoundException(
    val friendshipId: UUID? = null,
    title: String = "Friendship not found",
    message: String = friendshipId?.let { "Friendship $it not found" } ?: "Friendship not found",
    errorCode: String = "FRIENDSHIP_NOT_FOUND",
) : DomainException(title, message, errorCode)
