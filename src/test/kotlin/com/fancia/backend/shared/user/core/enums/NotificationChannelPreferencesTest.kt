package com.fancia.backend.shared.user.core.enums

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NotificationChannelPreferencesTest : FunSpec({
    test("allowsPush respects NONE and EMAIL_ONLY") {
        null.allowsPush() shouldBe true
        NotificationChannel.BOTH.allowsPush() shouldBe true
        NotificationChannel.PUSH_ONLY.allowsPush() shouldBe true
        NotificationChannel.EMAIL_ONLY.allowsPush() shouldBe false
        NotificationChannel.NONE.allowsPush() shouldBe false
    }

    test("allowsEmail respects NONE and PUSH_ONLY") {
        null.allowsEmail() shouldBe true
        NotificationChannel.BOTH.allowsEmail() shouldBe true
        NotificationChannel.EMAIL_ONLY.allowsEmail() shouldBe true
        NotificationChannel.PUSH_ONLY.allowsEmail() shouldBe false
        NotificationChannel.NONE.allowsEmail() shouldBe false
    }
})
