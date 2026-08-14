package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ChatAccessDeniedException(
    title: String = "Cannot message this person",
    message: String = "You can only message people you are connected with through Smart Match",
    errorCode: String = "CHAT_ACCESS_DENIED",
) : DomainException(title, message, errorCode)
