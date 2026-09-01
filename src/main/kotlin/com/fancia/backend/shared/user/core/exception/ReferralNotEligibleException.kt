package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ReferralNotEligibleException(
    message: String = "Referral rewards are only available for new signups",
    title: String = "Not eligible",
    errorCode: String = "REFERRAL_NOT_ELIGIBLE",
) : DomainException(title, message, errorCode)
