package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.util.*

@Entity
@Table(
    name = "smart_matches",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["created_by", "user_id"]),
    ],
)
class SmartMatch : AbstractEntity() {
    @Column(name = "user_id", nullable = false)
    var userId: UUID? = null

    @Column(name = "matched_by_user", nullable = false)
    var matchedByUser: Boolean = false

    @Column(name = "matched_by_created_by", nullable = false)
    var matchedByCreatedBy: Boolean = false
}
