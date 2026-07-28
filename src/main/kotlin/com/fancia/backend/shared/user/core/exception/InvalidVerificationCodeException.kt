package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class InvalidVerificationCodeException(
    title: String = "Invalid Verification Code",
    message: String = "Invalid verification code provided",
    errorCode: String = "INVALID_VERIFICATION_CODE"
) : DomainException(title, message, errorCode)