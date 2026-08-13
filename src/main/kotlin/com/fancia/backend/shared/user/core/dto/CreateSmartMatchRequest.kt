package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotNull
import java.util.*

data class CreateSmartMatchRequest(
    @field:NotNull(message = "Matched user id is required")
    val userId: UUID,
    /** true = like, false = pass. Defaults to like for backwards compatibility. */
    val liked: Boolean = true,
)
