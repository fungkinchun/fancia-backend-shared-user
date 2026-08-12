package com.fancia.backend.shared.user.core.dto

data class UpdateSmartMatchRequest(
    val userIdFlag: Boolean? = null,
    val targetIdFlag: Boolean? = null,
    @Deprecated("Use userIdFlag")
    val matchedByCreatedBy: Boolean? = null,
    @Deprecated("Use targetIdFlag")
    val matchedByUser: Boolean? = null,
) {
    fun resolvedUserIdFlag(): Boolean? = userIdFlag ?: matchedByCreatedBy
    fun resolvedTargetIdFlag(): Boolean? = targetIdFlag ?: matchedByUser
}
