package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.common.core.utils.Default
import java.util.UUID

/**
 * Precomputed “do this together” suggestion for a mutual Smart Match pair.
 * Clients resolve title/location/start from the event service via [eventId].
 */
data class PairEventIcebreakerResponse @Default constructor(
    val eventId: UUID,
    val score: Double = 0.0,
    val sharedTagIds: Set<UUID> = emptySet(),
)
