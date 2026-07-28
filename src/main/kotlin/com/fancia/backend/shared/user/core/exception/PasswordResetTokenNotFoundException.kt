package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class PasswordResetTokenNotFoundException(
    title: String = "Password Reset Token Not Found",
    message: String = "Password reset token not found",
    errorCode: String = "PASSWORD_RESET_TOKEN_NOT_FOUND"
) : DomainException(title, message, errorCode)