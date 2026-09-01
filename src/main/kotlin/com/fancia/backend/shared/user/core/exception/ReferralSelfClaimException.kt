package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ReferralSelfClaimException(
    title: String = "Invalid referral",
    message: String = "You cannot use your own referral link",
    errorCode: String = "REFERRAL_SELF",
) : DomainException(title, message, errorCode)
