package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class UserWithEmailNotFoundException(
    val email: String,
    title: String = "User Not Found with Email",
    message: String = "User not found with email: $email",
    errorCode: String = "USER_NOT_FOUND_WITH_EMAIL"
) : DomainException(title, message, errorCode)