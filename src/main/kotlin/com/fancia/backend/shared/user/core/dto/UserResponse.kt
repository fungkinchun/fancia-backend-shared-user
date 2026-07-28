package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.utils.Default
import com.fancia.backend.shared.common.social.core.dto.LinkResponse
import com.fancia.backend.shared.user.core.enums.AccountStatus
import com.fancia.backend.shared.user.core.enums.Gender
import com.fancia.backend.shared.user.core.enums.ProfileVisibility
import com.fancia.backend.shared.user.core.enums.Role
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class UserResponse @Default constructor(
    val id: UUID? = null,
    val role: Role? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val status: AccountStatus = AccountStatus.REGISTERED,
    val profileImageUrl: String? = null,
    val bio: String? = null,
    val locationLabel: String? = null,
    var birthDate: LocalDate? = null,
    var gender: Gender? = null,
    val visibility: ProfileVisibility = ProfileVisibility.PUBLIC,
    var tags: Set<UUID> = emptySet(),
    var blacklistedIds: Set<UUID> = emptySet(),
    var privacy: UserPrivacySettings = UserPrivacySettings(),
    var notifications: UserNotificationSettings = UserNotificationSettings(),
    val connectedAccounts: MutableList<ConnectedAccountResponse> = mutableListOf(),
    val authorities: MutableList<String> = mutableListOf(),
    val links: Set<LinkResponse> = emptySet(),
)

data class ConnectedAccountResponse(val provider: String?, val connectedAt: LocalDateTime?)