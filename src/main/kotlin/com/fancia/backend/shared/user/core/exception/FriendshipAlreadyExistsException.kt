package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class FriendshipAlreadyExistsException(
    val userId: UUID,
    title: String = "Friendship already exists",
    message: String = "An active friendship or request already exists with user $userId",
    errorCode: String = "FRIENDSHIP_ALREADY_EXISTS",
) : DomainException(title, message, errorCode)
