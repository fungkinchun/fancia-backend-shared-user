package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.common.core.utils.Slugify
import com.fancia.backend.shared.user.core.entity.User

object DefaultUserSlug {
    private val HANDLE_PATTERN = Regex("^[a-z0-9][a-z0-9-]{2,29}$")

    val RESERVED_HANDLES = setOf(
        "profile",
        "profiles",
        "settings",
        "api",
        "admin",
        "events",
        "event",
        "venues",
        "venue",
        "groups",
        "group",
        "login",
        "signup",
        "sign-up",
        "register",
        "help",
        "terms",
        "privacy",
        "discover",
        "messages",
        "friends",
        "calendar",
        "smart-match",
        "create-event",
        "create-venue",
        "create-group",
        "me",
        "email",
        "handles",
        "handle",
        "users",
        "user",
        "www",
        "r",
    )

    fun generate(user: User, isTaken: (String) -> Boolean): String {
        val root = normalizeCandidate(buildBase(user))
        return Slugify.allocateUnique(root, fallback = "user") { candidate ->
            !isValidHandle(candidate) || isTaken(candidate)
        }.let { allocated ->
            if (isValidHandle(allocated) && !isTaken(allocated)) {
                allocated
            } else {
                fallbackUnique(isTaken)
            }
        }
    }

    private fun buildBase(user: User): String {
        val namePart = listOfNotNull(user.firstName, user.lastName)
            .joinToString("-") { Slugify.slugify(it.trim(), fallback = "") }
            .trim('-')
        if (namePart.length >= 3) return namePart

        val emailLocal = user.email?.substringBefore('@').orEmpty()
        val emailPart = Slugify.slugify(emailLocal, fallback = "")
        if (emailPart.length >= 3) return emailPart

        return "user"
    }

    private fun normalizeCandidate(raw: String): String {
        val slug = Slugify.slugify(raw, fallback = "user")
        val trimmed = slug.take(26).trim('-')
        return trimmed.ifBlank { "user" }
    }

    private fun isValidHandle(handle: String): Boolean =
        handle.isNotBlank() &&
            HANDLE_PATTERN.matches(handle) &&
            handle !in RESERVED_HANDLES

    private fun fallbackUnique(isTaken: (String) -> Boolean): String {
        for (n in 1..100) {
            val suffix = n.toString()
            val candidate = "user-${suffix.padStart(2, '0')}".take(30)
            if (isValidHandle(candidate) && !isTaken(candidate)) return candidate
        }
        return "user-${java.util.UUID.randomUUID().toString().replace("-", "").take(8)}"
    }
}
