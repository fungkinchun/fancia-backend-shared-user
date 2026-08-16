package com.fancia.backend.shared.user.core.dto

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class CreateGroupInquiryRequest(
    @field:NotNull(message = "Interest group id is required")
    val interestGroupId: UUID,
)
