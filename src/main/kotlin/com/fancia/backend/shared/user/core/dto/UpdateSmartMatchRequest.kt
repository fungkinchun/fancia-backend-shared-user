package com.fancia.backend.shared.user.core.dto

data class UpdateSmartMatchRequest(
    val firstUserLiked: Boolean? = null,
    val secondUserLiked: Boolean? = null,
    @Deprecated("Use firstUserLiked")
    val userIdFlag: Boolean? = null,
    @Deprecated("Use secondUserLiked")
    val targetIdFlag: Boolean? = null,
    @Deprecated("Use firstUserLiked")
    val matchedByCreatedBy: Boolean? = null,
    @Deprecated("Use secondUserLiked")
    val matchedByUser: Boolean? = null,
) {
    fun resolvedFirstUserLiked(): Boolean? = firstUserLiked ?: userIdFlag ?: matchedByCreatedBy

    fun resolvedSecondUserLiked(): Boolean? = secondUserLiked ?: targetIdFlag ?: matchedByUser
}
