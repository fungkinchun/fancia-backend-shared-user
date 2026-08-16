package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class FriendRequestNotAllowedException(
    title: String = "Friend request not allowed",
    message: String = "This user is not accepting friend requests",
    errorCode: String = "FRIEND_REQUEST_NOT_ALLOWED",
) : DomainException(title, message, errorCode)
