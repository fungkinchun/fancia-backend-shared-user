package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.time.LocalDateTime

class UserSlugInvalidException(
    message: String = "Slug is invalid",
) : DomainException(
    title = "Invalid slug",
    message = message,
    errorCode = "HANDLE_INVALID",
)

class UserSlugTakenException(
    handle: String,
) : DomainException(
    title = "Slug unavailable",
    message = "Slug '$handle' is already taken",
    errorCode = "HANDLE_TAKEN",
)

class UserSlugChangeCooldownException(
    val nextAllowedAt: LocalDateTime,
) : DomainException(
    title = "Slug change not allowed yet",
    message = "Changeable until $nextAllowedAt",
    errorCode = "HANDLE_CHANGE_COOLDOWN",
)

class UserProfileNotFoundException(
    ref: String,
) : DomainException(
    title = "User not found",
    message = "User not found with id or slug: $ref",
    errorCode = "USER_NOT_FOUND",
)
