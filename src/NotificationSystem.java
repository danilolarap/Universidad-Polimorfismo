import java.util.Date;
import models.*;
import services.*;

// Gestor Principal
public class NotificationSystem {
    public static void main(String[] args) {
        Notification grade = new GradeNotification(
            "N-001", "Andres Jaramillo", "Has aprobado exitosamente!", new Date(), NotificationStatus.PENDING, "Programacion", 4.5
        );

        Notification cancellation = new ClassCancellationNotification(
            "N-002", "Valeria Montoya", "La clase se suspendio.", new Date(), NotificationStatus.PENDING, "Profesor Gomez", "Salud"
        );

        NotificationChannel email = new EmailService();
        NotificationChannel sms = new SMSService();
        NotificationChannel push = new PushNotificationService();

        // Envio multiple
        email.send(grade);
        sms.send(grade);
        push.send(grade);

        System.out.println("*************************************************");
        
        email.send(cancellation);
        push.send(cancellation);
    }
}
