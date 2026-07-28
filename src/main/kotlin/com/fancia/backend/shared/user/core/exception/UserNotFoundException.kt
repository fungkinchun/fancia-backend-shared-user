package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class UserNotFoundException(
    title: String = "User Not Found",
    message: String = "User not found",
    errorCode: String = "USER_NOT_FOUND"
) : DomainException(title, message, errorCode)