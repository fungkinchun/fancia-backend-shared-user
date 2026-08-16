package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class FriendshipAccessDeniedException(
    title: String = "Friendship access denied",
    message: String = "You are not allowed to perform this friendship action",
    errorCode: String = "FRIENDSHIP_ACCESS_DENIED",
) : DomainException(title, message, errorCode)
