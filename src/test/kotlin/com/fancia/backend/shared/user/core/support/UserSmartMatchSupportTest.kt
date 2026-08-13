package com.fancia.backend.shared.user.core.support

import com.fancia.backend.shared.user.core.dto.UserPrivacySettings
import com.fancia.backend.shared.user.core.entity.User
import com.fancia.backend.shared.user.core.entity.UserSettings
import com.fancia.backend.shared.user.core.enums.AccountStatus
import com.fancia.backend.shared.user.core.enums.ProfileVisibility
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.UUID

class UserSmartMatchSupportTest : FunSpec({
    fun user(
        status: AccountStatus = AccountStatus.ACTIVE,
        visibility: ProfileVisibility = ProfileVisibility.PUBLIC,
        smartMatchEnabled: Boolean = false,
    ): User {
        val userId = UUID.randomUUID()
        return User().apply {
            id = userId
            this.status = status
            this.visibility = visibility
            settings = UserSettings().apply {
                this.userId = userId
                privacy = UserPrivacySettings(smartMatchEnabled = smartMatchEnabled)
            }
        }
    }

    test("smartMatchEligible requires active public profile with smart match enabled") {
        user(smartMatchEnabled = true).smartMatchEligible() shouldBe true
        user(smartMatchEnabled = false).smartMatchEligible() shouldBe false
        user(visibility = ProfileVisibility.PRIVATE, smartMatchEnabled = true).smartMatchEligible() shouldBe false
        user(status = AccountStatus.INACTIVE, smartMatchEnabled = true).smartMatchEligible() shouldBe false
    }
})
