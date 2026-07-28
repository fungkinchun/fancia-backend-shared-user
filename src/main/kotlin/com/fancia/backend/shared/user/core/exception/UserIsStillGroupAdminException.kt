package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class UserIsStillGroupAdminException(
    val id: String,
    val groupIds: List<String>,
    title: String = "User is still an admin of interest groups",
    message: String = "User with id $id is still an admin of the following interest groups: ${
        groupIds.joinToString(
            ", "
        )
    }. Please transfer the admin role to another user before deleting this user.",
    errorCode: String = "USER_STILL_GROUP_ADMIN"
) : DomainException(title, message, errorCode)