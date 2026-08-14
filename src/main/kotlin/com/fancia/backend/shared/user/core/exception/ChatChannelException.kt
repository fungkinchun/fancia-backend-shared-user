package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ChatChannelException(
    title: String = "Could not open conversation",
    message: String = "Something went wrong while opening this chat",
    errorCode: String = "CHAT_CHANNEL_ERROR",
) : DomainException(title, message, errorCode)
