package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.apache.commons.lang3.RandomStringUtils

@Entity
@Table(name = "verification_codes")
class VerificationCode() : AbstractEntity() {
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    var user: User? = null
    val code: String = RandomStringUtils.random(6, false, true)
    var emailSent: Boolean = false

    constructor(user: User?) : this() {
        this.user = user
    }
}