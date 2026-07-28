package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class PasswordResetTokenExpiredException(
    title: String = "Password Reset Token Expired",
    message: String = "Password reset token has expired. Please request a new one.",
    errorCode: String = "PASSWORD_RESET_TOKEN_EXPIRED"
) : DomainException(title, message, errorCode)