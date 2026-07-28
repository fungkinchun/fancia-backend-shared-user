package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.*

class SmartMatchNotFoundException(
    val smartMatchId: UUID,
    title: String = "Smart match not found",
    message: String = "Smart match $smartMatchId not found",
    errorCode: String = "SMART_MATCH_NOT_FOUND",
) : DomainException(title, message, errorCode)

class SmartMatchAlreadyExistsException(
    val userId: UUID,
    title: String = "Smart match already exists",
    message: String = "Smart match with user $userId already exists",
    errorCode: String = "SMART_MATCH_ALREADY_EXISTS",
) : DomainException(title, message, errorCode)

class SmartMatchAccessDeniedException(
    title: String = "Smart match access denied",
    message: String = "You are not allowed to update this smart match",
    errorCode: String = "SMART_MATCH_ACCESS_DENIED",
) : DomainException(title, message, errorCode)

class SmartMatchSelfMatchException(
    title: String = "Cannot smart match yourself",
    message: String = "You cannot create a smart match with yourself",
    errorCode: String = "SMART_MATCH_SELF_MATCH",
) : DomainException(title, message, errorCode)
