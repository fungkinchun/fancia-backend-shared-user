package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.dto.UserPrivacySettings
import com.fancia.backend.shared.user.core.dto.UserResponse
import com.fancia.backend.shared.user.core.enums.Gender
import com.fancia.backend.shared.user.core.enums.ProfileVisibility
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.util.UUID

class UserProfileRedactionTest : FunSpec({
    test("keeps fields when privacy defaults are true") {
        val userId = UUID.randomUUID()
        val response = UserResponse(
            id = userId,
            firstName = "Public",
            lastName = "User",
            gender = Gender.M,
            birthDate = LocalDate.of(1990, 1, 1),
            tags = setOf(UUID.randomUUID()),
            visibility = ProfileVisibility.PUBLIC,
            privacy = UserPrivacySettings(),
        )

        val redacted = response.redactForPublicView()

        redacted.gender shouldBe Gender.M
        redacted.birthDate shouldBe LocalDate.of(1990, 1, 1)
        redacted.tags.size shouldBe 1
    }

    test("redacts fields when privacy toggles are disabled") {
        val response = UserResponse(
            id = UUID.randomUUID(),
            gender = Gender.F,
            birthDate = LocalDate.of(1995, 5, 5),
            tags = setOf(UUID.randomUUID()),
            visibility = ProfileVisibility.PUBLIC,
            privacy = UserPrivacySettings(
                showGender = false,
                showBirthday = false,
                showInterests = false,
            ),
        )

        val redacted = response.redactForPublicView()

        redacted.gender.shouldBeNull()
        redacted.birthDate.shouldBeNull()
        redacted.tags.shouldBeEmpty()
    }

    test("canViewProfileSection follows boolean privacy flags") {
        canViewProfileSection(UserPrivacySettings(), ProfileSection.Groups) shouldBe true
        canViewProfileSection(UserPrivacySettings(showGroups = false), ProfileSection.Groups) shouldBe false
        canViewProfileSection(UserPrivacySettings(showEvents = false), ProfileSection.Events) shouldBe false
        canViewProfileSection(UserPrivacySettings(showInterests = false), ProfileSection.Interests) shouldBe false
    }

    test("private visibility keeps profile basics and interest count only") {
        val response = UserResponse(
            id = UUID.randomUUID(),
            firstName = "Hidden",
            lastName = "User",
            email = "hidden@example.com",
            bio = "Secret bio",
            profileImageUrl = "https://example.com/pic.jpg",
            gender = Gender.M,
            birthDate = LocalDate.of(1990, 1, 1),
            tags = setOf(UUID.randomUUID(), UUID.randomUUID()),
            visibility = ProfileVisibility.PRIVATE,
            privacy = UserPrivacySettings(),
        )

        val redacted = response.redactForPublicView()

        redacted.firstName shouldBe "Hidden"
        redacted.lastName shouldBe "User"
        redacted.bio shouldBe "Secret bio"
        redacted.profileImageUrl shouldBe "https://example.com/pic.jpg"
        redacted.interestsCount shouldBe 2
        redacted.email.shouldBeNull()
        redacted.gender.shouldBeNull()
        redacted.tags.shouldBeEmpty()
    }
})
