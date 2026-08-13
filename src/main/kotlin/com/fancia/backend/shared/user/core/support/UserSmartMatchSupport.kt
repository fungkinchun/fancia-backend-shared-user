package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.entity.User
import com.fancia.backend.shared.user.core.enums.AccountStatus
import com.fancia.backend.shared.user.core.enums.ProfileVisibility

fun User.smartMatchEligible(): Boolean =
    status == AccountStatus.ACTIVE &&
        visibility == ProfileVisibility.PUBLIC &&
        settings?.privacy?.smartMatchEnabled == true
