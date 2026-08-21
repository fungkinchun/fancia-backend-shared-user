package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "user_connected_accounts")
@Inheritance(strategy = InheritanceType.JOINED)
open class UserConnectedAccount(
    val provider: String?,
    val providerId: String?,
    @ManyToOne @JoinColumn(name = "user_id") @JsonIgnore val user: User?
) :
    AbstractEntity() {
    val connectedAt: LocalDateTime? = LocalDateTime.now()
}
