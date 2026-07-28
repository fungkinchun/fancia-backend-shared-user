package com.fancia.backend.shared.user.core.message

import java.util.*

data class UserDeletedEvent(
    val id: UUID
)