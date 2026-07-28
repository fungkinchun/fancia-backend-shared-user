package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class InvalidPasswordException(
    title: String = "Invalid password",
    message: String = "The password provided does not meet the required criteria or is incorrect.",
    errorCode: String = "INVALID_PASSWORD"
) : DomainException(title, message, errorCode)