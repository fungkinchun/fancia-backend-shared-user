package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fancia.backend.shared.user.core.dto.PairEventIcebreakerResponse
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(
    name = "smart_matches",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_smart_matches_first_second", columnNames = ["first_user_id", "second_user_id"]),
    ],
)
class SmartMatch : AbstractEntity() {
    /** Deck owner / row initiator (formerly user_id). */
    @Column(name = "first_user_id", nullable = false)
    var firstUserId: UUID? = null

    /** Other person in the pair (formerly target_id). */
    @Column(name = "second_user_id", nullable = false)
    var secondUserId: UUID? = null

    @Column(name = "first_user_liked")
    var firstUserLiked: Boolean? = null

    @Column(name = "second_user_liked")
    var secondUserLiked: Boolean? = null

    @Column(name = "first_user_liked_at")
    var firstUserLikedAt: LocalDateTime? = null

    @Column(name = "second_user_liked_at")
    var secondUserLikedAt: LocalDateTime? = null

    @Column(name = "rank")
    var rank: Int? = null

    @Column(name = "score")
    var score: Double? = null

    @OneToMany(mappedBy = "smartMatch", cascade = [CascadeType.ALL], orphanRemoval = true)
    @OrderBy("score DESC")
    var icebreakerEvents: MutableList<SmartMatchIcebreakerEvent> = mutableListOf()

    @Column(name = "icebreaker_computed_at")
    var icebreakerComputedAt: LocalDateTime? = null

    fun replaceIcebreakerEvents(events: List<PairEventIcebreakerResponse>, computedAt: LocalDateTime) {
        icebreakerEvents.clear()
        events.forEach { dto ->
            icebreakerEvents.add(SmartMatchIcebreakerEvent.fromResponse(this, dto))
        }
        icebreakerComputedAt = computedAt
    }

    fun icebreakerEventResponses(): List<PairEventIcebreakerResponse> =
        icebreakerEvents.map { it.toResponse() }

    fun otherUserId(forUserId: UUID): UUID? = when (forUserId) {
        firstUserId -> secondUserId
        secondUserId -> firstUserId
        else -> null
    }

    fun likedBy(forUserId: UUID): Boolean? = when (forUserId) {
        firstUserId -> firstUserLiked
        secondUserId -> secondUserLiked
        else -> null
    }

    fun likedAt(forUserId: UUID): LocalDateTime? = when (forUserId) {
        firstUserId -> firstUserLikedAt
        secondUserId -> secondUserLikedAt
        else -> null
    }

    fun setLikedBy(forUserId: UUID, liked: Boolean?, at: LocalDateTime?) {
        when (forUserId) {
            firstUserId -> {
                firstUserLiked = liked
                firstUserLikedAt = at
            }
            secondUserId -> {
                secondUserLiked = liked
                secondUserLikedAt = at
            }
        }
    }

    fun eitherLiked(): Boolean = firstUserLiked == true || secondUserLiked == true

    fun mutualLike(): Boolean = firstUserLiked == true && secondUserLiked == true

    fun hasNotPassed(forUserId: UUID): Boolean = likedBy(forUserId) != false
}
