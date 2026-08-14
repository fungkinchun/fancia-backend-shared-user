package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ChatNotConfiguredException(
    title: String = "Chat unavailable",
    message: String = "Direct messages are not configured on this environment",
    errorCode: String = "CHAT_NOT_CONFIGURED",
) : DomainException(title, message, errorCode)
