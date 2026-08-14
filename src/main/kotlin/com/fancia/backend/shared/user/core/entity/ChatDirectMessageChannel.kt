package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.util.UUID

@Entity
@Table(
    name = "chat_direct_message_channels",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_chat_dm_channels_users",
            columnNames = ["first_user_id", "second_user_id"],
        ),
        UniqueConstraint(
            name = "uk_chat_dm_channels_channel_id",
            columnNames = ["channel_id"],
        ),
    ],
)
class ChatDirectMessageChannel : AbstractEntity() {
    @Column(name = "first_user_id", nullable = false)
    var firstUserId: UUID? = null

    @Column(name = "second_user_id", nullable = false)
    var secondUserId: UUID? = null

    @Column(name = "channel_id", nullable = false, length = 64)
    var channelId: String = ""

    companion object {
        fun canonicalUserPair(first: UUID, second: UUID): Pair<UUID, UUID> {
            val sorted = listOf(first, second).sortedBy { it.toString() }
            return sorted[0] to sorted[1]
        }
    }
}
