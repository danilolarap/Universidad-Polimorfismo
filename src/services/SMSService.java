package services;

import models.Notification;
import models.NotificationStatus;

// Nuevo canal facilmente
public class SMSService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        long hash = Math.abs(notification.getRecipient().hashCode());
        String fakeNumber = "315" + String.format("%07d", hash % 10000000);
        System.out.println("Enviando SMS al numero: +57 " + fakeNumber + " (Destinatario: " + notification.getRecipient() + ")");
        notification.showDetails();
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("- Estado: Enviado (SMS) -\n");
    }
}
