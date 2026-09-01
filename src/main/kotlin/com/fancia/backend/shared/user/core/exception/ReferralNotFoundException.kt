package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ReferralNotFoundException(
    slug: String,
    title: String = "Referral not found",
    message: String = "No referrer found for handle '$slug'",
    errorCode: String = "REFERRAL_NOT_FOUND",
) : DomainException(title, message, errorCode)
