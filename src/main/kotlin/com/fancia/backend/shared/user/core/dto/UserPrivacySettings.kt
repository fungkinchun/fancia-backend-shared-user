package com.fancia.backend.shared.user.core.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserPrivacySettings(
    val allowFriendRequests: Boolean = true,
    val showGroups: Boolean = true,
    val showInterests: Boolean = true,
    val showEvents: Boolean = true,
    val showGender: Boolean = true,
    val showBirthday: Boolean = true,
    val smartMatchEnabled: Boolean = false,
)
