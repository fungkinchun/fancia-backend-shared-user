package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fancia.backend.shared.user.core.enums.FriendshipStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "friendships")
class Friendship : AbstractEntity() {
    @Column(name = "requester_id", nullable = false)
    var requesterId: UUID? = null

    @Column(name = "addressee_id", nullable = false)
    var addresseeId: UUID? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    var status: FriendshipStatus = FriendshipStatus.PENDING

    @Column(name = "responded_at")
    var respondedAt: LocalDateTime? = null

    fun otherUserId(forUserId: UUID): UUID? = when (forUserId) {
        requesterId -> addresseeId
        addresseeId -> requesterId
        else -> null
    }

    fun involves(userId: UUID): Boolean =
        requesterId == userId || addresseeId == userId
}
