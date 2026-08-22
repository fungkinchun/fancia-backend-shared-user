package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.time.LocalDateTime

class UserSlugInvalidException(
    message: String = "Profile URL handle is invalid",
) : DomainException(
    title = "Invalid profile handle",
    message = message,
    errorCode = "HANDLE_INVALID",
)

class UserSlugTakenException(
    handle: String,
) : DomainException(
    title = "Handle unavailable",
    message = "Profile URL '$handle' is already taken",
    errorCode = "HANDLE_TAKEN",
)

class UserSlugChangeCooldownException(
    val nextAllowedAt: LocalDateTime,
) : DomainException(
    title = "Handle change not allowed yet",
    message = "You can change your profile URL again after $nextAllowedAt",
    errorCode = "HANDLE_CHANGE_COOLDOWN",
)

class UserProfileNotFoundException(
    ref: String,
) : DomainException(
    title = "User not found",
    message = "User not found with id or handle: $ref",
    errorCode = "USER_NOT_FOUND",
)
