package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.user.core.dto.PairEventIcebreakerResponse
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

/**
 * One suggested “do this together” event for a [SmartMatch] row (mutual pairs only).
 * Hard-deleted via orphanRemoval when the cron replaces the set (no soft-delete).
 */
@Entity
@Table(
    name = "smart_match_icebreaker_events",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_smart_match_icebreaker_match_event",
            columnNames = ["smart_match_id", "event_id"],
        ),
    ],
)
class SmartMatchIcebreakerEvent {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @GeneratedValue
    var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "smart_match_id", nullable = false)
    var smartMatch: SmartMatch? = null

    @Column(name = "event_id", nullable = false)
    var eventId: UUID? = null

    @Column(name = "score", nullable = false)
    var score: Double = 0.0

    @Column(name = "next_start")
    var nextStart: LocalDateTime? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "location_label")
    var locationLabel: String? = null

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "smart_match_icebreaker_event_shared_tags",
        joinColumns = [JoinColumn(name = "icebreaker_event_id")],
    )
    @Column(name = "tag_id", nullable = false)
    var sharedTagIds: MutableSet<UUID> = mutableSetOf()

    fun toResponse(): PairEventIcebreakerResponse =
        PairEventIcebreakerResponse(
            eventId = requireNotNull(eventId),
            score = score,
            nextStart = nextStart,
            sharedTagIds = sharedTagIds.toSet(),
            name = name,
            locationLabel = locationLabel,
        )

    companion object {
        fun fromResponse(
            parent: SmartMatch,
            dto: PairEventIcebreakerResponse,
        ): SmartMatchIcebreakerEvent =
            SmartMatchIcebreakerEvent().apply {
                smartMatch = parent
                eventId = dto.eventId
                score = dto.score
                nextStart = dto.nextStart
                name = dto.name
                locationLabel = dto.locationLabel
                sharedTagIds = dto.sharedTagIds.toMutableSet()
            }
    }
}
