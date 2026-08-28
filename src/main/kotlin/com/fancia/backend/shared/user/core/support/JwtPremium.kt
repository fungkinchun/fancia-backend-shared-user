package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.entity.User
import org.springframework.security.oauth2.jwt.Jwt

fun Jwt.isPremiumClaim(): Boolean {
    val claim = claims["isPremium"] ?: return false
    return when (claim) {
        is Boolean -> claim
        is String -> claim.equals("true", ignoreCase = true)
        is Number -> claim.toInt() != 0
        else -> false
    }
}

fun hasPremiumAccess(jwt: Jwt, user: User? = null): Boolean =
    user?.premiumActive == true || jwt.isPremiumClaim()
