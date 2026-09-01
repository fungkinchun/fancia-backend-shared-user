package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ReferralAlreadyClaimedException(
    title: String = "Referral already claimed",
    message: String = "This account has already claimed a referral reward",
    errorCode: String = "REFERRAL_ALREADY_CLAIMED",
) : DomainException(title, message, errorCode)
