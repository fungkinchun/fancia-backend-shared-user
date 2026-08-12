package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.dto.UserNotificationSettings
import com.fancia.backend.shared.user.core.dto.UserPrivacySettings
import com.fancia.backend.shared.user.core.dto.UserResponse
import com.fancia.backend.shared.user.core.enums.ProfileVisibility

/**
 * Redacts profile fields that must not appear on public user lookups.
 * Call for GET /users/{id}, GET /users/email/{email}, and Smart Match results — not for /users/me.
 */
fun UserResponse.redactForPublicView(): UserResponse {
    if (visibility == ProfileVisibility.PRIVATE) {
        return UserResponse(
            id = id,
            firstName = "",
            lastName = "",
            profileImageUrl = profileImageUrl,
            visibility = ProfileVisibility.PRIVATE,
        )
    }

    notifications = UserNotificationSettings()

    if (!privacy.showGender) {
        gender = null
    }
    if (!privacy.showBirthday) {
        birthDate = null
    }
    if (!privacy.showInterests) {
        tags = emptySet()
        blacklistedIds = emptySet()
    }

    return this
}

fun canViewProfileSection(
    privacy: UserPrivacySettings,
    section: ProfileSection,
): Boolean = when (section) {
    ProfileSection.Events -> privacy.showEvents
    ProfileSection.Groups -> privacy.showGroups
    ProfileSection.Interests -> privacy.showInterests
}

enum class ProfileSection {
    Events,
    Groups,
    Interests,
}
