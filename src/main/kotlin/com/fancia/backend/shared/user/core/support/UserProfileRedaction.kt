package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.dto.UserNotificationSettings
import com.fancia.backend.shared.user.core.dto.UserPrivacySettings
import com.fancia.backend.shared.user.core.dto.UserResponse
import com.fancia.backend.shared.user.core.enums.ProfileVisibility

fun UserResponse.redactForPublicView(): UserResponse {
    if (visibility == ProfileVisibility.PRIVATE) {
        return UserResponse(
            id = id,
            firstName = firstName,
            lastName = lastName,
            profileImageUrl = profileImageUrl,
            bio = bio,
            visibility = ProfileVisibility.PRIVATE,
            interestsCount = tags.size,
            postsCount = postsCount,
            eventsCount = eventsCount,
            groupsCount = groupsCount,
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
