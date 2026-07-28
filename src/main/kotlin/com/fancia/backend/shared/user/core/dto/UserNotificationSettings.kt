package com.fancia.backend.shared.user.core.dto

import com.fancia.backend.shared.user.core.enums.DeviceType
import com.fancia.backend.shared.user.core.enums.NotificationChannel

data class UserNotificationSettings(
    val match: NotificationChannel? = null,
    val messages: NotificationChannel? = null,
    val postEngagement: NotificationChannel? = null,
    val eventRecommendations: NotificationChannel? = null,
    val eventReminders: NotificationChannel? = null,
    val fcmToken: String? = null,
    val deviceType: DeviceType? = null,
    val deviceId: String? = null,
)
