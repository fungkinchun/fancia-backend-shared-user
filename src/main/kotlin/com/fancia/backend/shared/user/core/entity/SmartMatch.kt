package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(
    name = "smart_matches",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_smart_matches_user_target", columnNames = ["user_id", "target_id"]),
    ],
)
class SmartMatch : AbstractEntity() {
    @Column(name = "user_id", nullable = false)
    var userId: UUID? = null

    @Column(name = "target_id", nullable = false)
    var targetId: UUID? = null

    @Column(name = "user_id_flag")
    var userIdFlag: Boolean? = null

    @Column(name = "target_id_flag")
    var targetIdFlag: Boolean? = null

    @Column(name = "user_id_flag_at")
    var userIdFlagAt: LocalDateTime? = null

    @Column(name = "target_id_flag_at")
    var targetIdFlagAt: LocalDateTime? = null

    @Column(name = "rank")
    var rank: Int? = null

    @Column(name = "score")
    var score: Double? = null
}
