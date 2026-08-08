package com.fancia.backend.shared.user.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class SubscriptionNotFoundException(
    title: String = "Subscription Not Found",
    message: String = "Subscription not found",
    errorCode: String = "SUBSCRIPTION_NOT_FOUND",
) : DomainException(title, message, errorCode) {
    constructor(id: UUID) : this(message = "Subscription not found: $id")
}

class SubscriptionAlreadyLinkedException(
    title: String = "Subscription Already Linked",
    message: String = "This provider subscription is already linked to another user",
    errorCode: String = "SUBSCRIPTION_ALREADY_LINKED",
) : DomainException(title, message, errorCode)

class InvalidAppleNotificationException(
    title: String = "Invalid Apple Notification",
    message: String = "Apple App Store notification could not be verified or decoded",
    errorCode: String = "INVALID_APPLE_NOTIFICATION",
) : DomainException(title, message, errorCode)

class InvalidGoogleNotificationException(
    title: String = "Invalid Google Notification",
    message: String = "Google Play notification could not be verified or decoded",
    errorCode: String = "INVALID_GOOGLE_NOTIFICATION",
) : DomainException(title, message, errorCode)

class InvalidStripeNotificationException(
    title: String = "Invalid Stripe Notification",
    message: String = "Stripe webhook could not be verified or decoded",
    errorCode: String = "INVALID_STRIPE_NOTIFICATION",
) : DomainException(title, message, errorCode)

class WebhookNotImplementedException(
    provider: String,
    title: String = "Webhook Not Implemented",
    message: String = "Webhook handling for $provider is not implemented yet",
    errorCode: String = "WEBHOOK_NOT_IMPLEMENTED",
) : DomainException(title, message, errorCode)
