package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.utils.Default
import java.time.LocalDateTime
import java.util.UUID

/** Precomputed “do this together” event suggestion for a mutual Smart Match pair. */
data class PairEventIcebreakerResponse @Default constructor(
    val eventId: UUID,
    val score: Double = 0.0,
    val nextStart: LocalDateTime? = null,
    val sharedTagIds: Set<UUID> = emptySet(),
    val name: String? = null,
    val locationLabel: String? = null,
)
