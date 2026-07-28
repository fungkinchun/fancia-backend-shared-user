package com.fancia.backend.shared.user.core.dto

data class UserPrivacySettings(
    val allowFriendRequests: Boolean? = null,
    val showGroups: Boolean? = null,
    val showInterests: Boolean? = null,
    val showEvents: Boolean? = null,
    val showGender: Boolean? = null,
    val showBirthday: Boolean? = null,
)
