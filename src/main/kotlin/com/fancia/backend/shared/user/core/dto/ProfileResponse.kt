package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.utils.Default
import com.fancia.backend.shared.common.social.core.dto.LinkResponse
import com.fancia.backend.shared.user.core.enums.Gender
import com.fancia.backend.shared.user.core.enums.ProfileVisibility
import java.time.LocalDate
import java.util.UUID

data class ProfileResponse @Default constructor(
    val id: UUID? = null,
    val slug: String? = null,
    val slugChangeAllowedAt: java.time.LocalDateTime? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val profileImageUrl: String? = null,
    val bio: String? = null,
    val locationLabel: String? = null,
    val birthDate: LocalDate? = null,
    val gender: Gender? = null,
    val visibility: ProfileVisibility = ProfileVisibility.PUBLIC,
    val tags: Set<UUID> = emptySet(),
    val links: Set<LinkResponse> = emptySet(),
    val interestsCount: Int? = null,
    val postsCount: Int? = null,
    val eventsCount: Int? = null,
    val groupsCount: Int? = null,
    val premiumActive: Boolean = false,
)
