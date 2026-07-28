package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class UserWithIdNotFoundException(
    val id: String,
    title: String = "User Not Found with ID",
    message: String = "User not found with id: $id",
    errorCode: String = "USER_NOT_FOUND_WITH_ID"
) : DomainException(title, message, errorCode)