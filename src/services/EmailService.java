package services;

import models.Notification;
import models.NotificationStatus;

// Nuevo canal facilmente
public class EmailService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        String baseName = notification.getRecipient().toLowerCase().replace(" ", ".");
        System.out.println("Enviando correo a: " + baseName + "@uni.edu.co");
        notification.showDetails();
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("- Estado: Enviado (Email) -\n");
    }
}
