package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fancia.backend.shared.user.core.enums.ChatChannelKind
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "chat_channels")
class ChatChannel : AbstractEntity() {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    var kind: ChatChannelKind = ChatChannelKind.DM

    @Column(name = "channel_id", nullable = false, length = 64)
    var channelId: String = ""

    @Column(name = "first_user_id")
    var firstUserId: UUID? = null

    @Column(name = "second_user_id")
    var secondUserId: UUID? = null

    @Column(name = "interest_group_id")
    var interestGroupId: UUID? = null

    @Column(name = "initiator_user_id")
    var initiatorUserId: UUID? = null

    @OneToMany(mappedBy = "chatChannel", cascade = [CascadeType.ALL], orphanRemoval = true)
    var members: MutableSet<ChatChannelMember> = mutableSetOf()

    fun addMember(userId: UUID, joinedAt: LocalDateTime = LocalDateTime.now()): ChatChannelMember {
        members.firstOrNull { it.userId == userId }?.let { return it }
        val member = ChatChannelMember().apply {
            this.chatChannel = this@ChatChannel
            this.userId = userId
            this.joinedAt = joinedAt
            this.createdBy = userId
        }
        members.add(member)
        return member
    }

    companion object {
        fun canonicalUserPair(first: UUID, second: UUID): Pair<UUID, UUID> {
            val sorted = listOf(first, second).sortedBy { it.toString() }
            return sorted[0] to sorted[1]
        }
    }
}
