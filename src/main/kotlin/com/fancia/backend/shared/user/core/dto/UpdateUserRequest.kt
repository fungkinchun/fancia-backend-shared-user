package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.validator.AgeRange
import com.fancia.backend.shared.common.social.core.dto.LinkItem
import com.fancia.backend.shared.common.tag.core.dto.TagItemRequest
import com.fancia.backend.shared.user.core.enums.DeviceType
import com.fancia.backend.shared.user.core.enums.Gender
import jakarta.validation.Valid
import java.time.LocalDate

data class UpdateUserRequest(
    val firstName: String? = null,
    val lastName: String? = null,

    val profileImageKey: String? = null,
    @field:Valid
    val links: List<LinkItem>? = null,
    val bio: String? = null,
    val locationLabel: String? = null,
    @field:AgeRange(min = 16, max = 120)
    val birthDate: LocalDate? = null,
    val gender: Gender? = null,
    @field:Valid
    val tags: Set<TagItemRequest>? = null,
    @field:Valid
    val blacklistTags: Set<TagItemRequest>? = null,
    val fcmToken: String? = null,
    val deviceType: DeviceType? = null,
    val deviceId: String? = null,
)
