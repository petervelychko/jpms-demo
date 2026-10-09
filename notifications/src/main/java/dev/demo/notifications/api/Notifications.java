package dev.demo.notifications.api;

import dev.demo.notifications.internal.ConsoleNotificationService;

public final class Notifications {
    private Notifications() {
    }

    public static NotificationService console() {
        return new ConsoleNotificationService();
    }
}
