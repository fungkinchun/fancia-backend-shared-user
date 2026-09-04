package com.fancia.backend.shared.user.core.enums

fun NotificationChannel?.allowsPush(): Boolean =
    when (this) {
        null,
        NotificationChannel.PUSH_ONLY,
        NotificationChannel.BOTH,
        -> true
        NotificationChannel.EMAIL_ONLY,
        NotificationChannel.NONE,
        -> false
    }

fun NotificationChannel?.allowsEmail(): Boolean =
    when (this) {
        null,
        NotificationChannel.EMAIL_ONLY,
        NotificationChannel.BOTH,
        -> true
        NotificationChannel.PUSH_ONLY,
        NotificationChannel.NONE,
        -> false
    }
