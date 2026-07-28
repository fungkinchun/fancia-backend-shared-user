package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Privilege : AbstractEntity() {
    @Column(nullable = false, unique = true)
    var name: String? = ""
}