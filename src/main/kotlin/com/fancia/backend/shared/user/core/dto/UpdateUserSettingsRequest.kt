package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.user.core.enums.ProfileVisibility

data class UpdateUserSettingsRequest(
    val visibility: ProfileVisibility? = null,
    val slug: String? = null,
    val privacy: UserPrivacySettings? = null,
    val notifications: UserNotificationSettings? = null,
)
