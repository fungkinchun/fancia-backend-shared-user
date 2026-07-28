package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.user.core.dto.UserNotificationSettings
import com.fancia.backend.shared.user.core.dto.UserPrivacySettings
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.*

@Entity
@Table(name = "user_settings")
class UserSettings {
    @Id
    @Column(name = "user_id")
    var userId: UUID? = null

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    var user: User? = null

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", nullable = false)
    var privacy: UserPrivacySettings = UserPrivacySettings()

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", nullable = false)
    var notifications: UserNotificationSettings = UserNotificationSettings()
}
