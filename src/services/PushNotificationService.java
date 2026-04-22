package services;

import models.Notification;
import models.NotificationStatus;

// Nuevo canal facilmente
public class PushNotificationService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        System.out.println("Enviando Push al dispositivo de: " + notification.getRecipient());
        notification.showDetails();
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("- Estado: Enviado (Push) -\n");
    }
}
