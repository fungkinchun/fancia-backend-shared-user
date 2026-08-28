package com.fancia.backend.shared.user.core.support

object PremiumLimits {
    const val PRODUCT_ID_MONTHLY = "com.fancify.fancia.premium.monthly"

    const val SMART_MATCH_DECK_FREE = 5
    const val SMART_MATCH_DECK_PREMIUM = 20
    const val GROUPS_FREE = 10
    const val PRIVATE_EVENTS_PER_MONTH_FREE = 5
    const val PAID_TIER_CAPACITY_FREE = 10
    const val PAID_RESERVATION_EARLY_ACCESS_HOURS = 24L
    const val EXPOSURE_SCORE_BONUS = 5.0

    fun smartMatchDeckSize(isPremium: Boolean): Int =
        if (isPremium) SMART_MATCH_DECK_PREMIUM else SMART_MATCH_DECK_FREE

    fun allowsUnlimitedGroups(isPremium: Boolean): Boolean = isPremium

    fun allowsUnlimitedPrivateEvents(isPremium: Boolean): Boolean = isPremium

    fun maxPaidTierCapacity(isPremium: Boolean): Int? =
        if (isPremium) null else PAID_TIER_CAPACITY_FREE
}
