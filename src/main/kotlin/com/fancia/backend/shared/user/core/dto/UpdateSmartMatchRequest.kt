package com.fancia.backend.shared.user.core.dto

data class UpdateSmartMatchRequest(
    val matchedByUser: Boolean? = null,
    val matchedByCreatedBy: Boolean? = null,
)
