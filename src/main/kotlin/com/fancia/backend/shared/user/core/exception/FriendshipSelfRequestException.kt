package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class FriendshipSelfRequestException(
    title: String = "Cannot friend yourself",
    message: String = "You cannot send a friend request to yourself",
    errorCode: String = "FRIENDSHIP_SELF_REQUEST",
) : DomainException(title, message, errorCode)
