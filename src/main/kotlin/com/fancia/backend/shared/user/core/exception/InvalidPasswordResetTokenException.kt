package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class InvalidPasswordResetTokenException(
    title: String = "Invalid Password Reset Token",
    message: String = "Invalid or expired password reset token.",
    errorCode: String = "INVALID_PASSWORD_RESET_TOKEN"
) : DomainException(title, message, errorCode)