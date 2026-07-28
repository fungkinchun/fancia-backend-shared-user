package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.apache.commons.lang3.RandomStringUtils
import java.time.LocalDateTime

@Entity
@Table(name = "password_reset_tokens")
class PasswordResetToken(@ManyToOne val user: User?) : AbstractEntity() {
    val token: String = RandomStringUtils.random(6, false, true)
    var emailSent = false
    var expiresAt: LocalDateTime? = null
    val isExpired: Boolean
        get() = expiresAt?.let { LocalDateTime.now().isAfter(it) } ?: false

    fun onEmailSent() {
        emailSent = true
        expiresAt = LocalDateTime.now().plusMinutes(10)
    }
}