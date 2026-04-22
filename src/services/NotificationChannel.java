package services;

import models.Notification;

// Interfaz Strategy (Extensible)
public interface NotificationChannel {
    void send(Notification notification);
}
