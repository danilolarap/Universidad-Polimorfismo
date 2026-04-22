import java.util.Date;

// 1. Enum de estado
enum NotificationStatus {
    PENDING, SENT, FAILED
}

// 2. Base abstracta
abstract class Notification {
    protected String code;
    protected String recipient;
    protected String message;
    protected Date sendDate;
    protected NotificationStatus status;

    public Notification(String code, String recipient, String message, Date sendDate, NotificationStatus status) {
        this.code = code;
        this.recipient = recipient;
        this.message = message;
        this.sendDate = sendDate;
        this.status = status;
    }

    public abstract void showDetails();

    public String getRecipient() { return recipient; }
    public void setStatus(NotificationStatus status) { this.status = status; }
}

// 3. Situacion Especializada A
class GradeNotification extends Notification {
    private String subject;
    private double grade;

    public GradeNotification(String code, String recipient, String message, Date sendDate, NotificationStatus status, String subject, double grade) {
        super(code, recipient, message, sendDate, status);
        this.subject = subject;
        this.grade = grade;
    }

    @Override
    public void showDetails() {
        System.out.println("--- Tipo: Calificacion ---");
        System.out.println("Materia: " + subject + " - Nota: " + grade);
        System.out.println("Mensaje: " + message);
    }
}

// 4. Situacion Especializada B
class EnrollmentNotification extends Notification {
    private double amount;
    private Date dueDate;

    public EnrollmentNotification(String code, String recipient, String message, Date sendDate, NotificationStatus status, double amount, Date dueDate) {
        super(code, recipient, message, sendDate, status);
        this.amount = amount;
        this.dueDate = dueDate;
    }

    @Override
    public void showDetails() {
        System.out.println("--- Tipo: Matricula ---");
        System.out.println("Monto: $" + amount + " - Vencimiento: " + dueDate);
        System.out.println("Mensaje: " + message);
    }
}

// 5. Situacion Especializada C
class ClassCancellationNotification extends Notification {
    private String professor;
    private String reason;

    public ClassCancellationNotification(String code, String recipient, String message, Date sendDate, NotificationStatus status, String professor, String reason) {
        super(code, recipient, message, sendDate, status);
        this.professor = professor;
        this.reason = reason;
    }

    @Override
    public void showDetails() {
        System.out.println("--- Tipo: Cancelacion ---");
        System.out.println("Profesor: " + professor + " - Motivo: " + reason);
        System.out.println("Mensaje: " + message);
    }
}

// 6. Situacion Especializada D
class EventRegistrationNotification extends Notification {
    private String eventName;
    private String location;

    public EventRegistrationNotification(String code, String recipient, String message, Date sendDate, NotificationStatus status, String eventName, String location) {
        super(code, recipient, message, sendDate, status);
        this.eventName = eventName;
        this.location = location;
    }

    @Override
    public void showDetails() {
        System.out.println("--- Tipo: Evento ---");
        System.out.println("Evento: " + eventName + " - Lugar: " + location);
        System.out.println("Mensaje: " + message);
    }
}

// 7. Interfaz Strategy (Extensible)
interface NotificationChannel {
    void send(Notification notification);
}

// 8. Medio de envio 1
class EmailService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        String baseName = notification.getRecipient().toLowerCase().replace(" ", ".");
        System.out.println("Enviando correo a: " + baseName + "@uni.edu.co");
        notification.showDetails();
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("- Estado: Enviado (Email) -\n");
    }
}

// 9. Medio de envio 2
class SMSService implements NotificationChannel {
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

// 10. Medio de envio 3
class PushNotificationService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        System.out.println("Enviando Push al dispositivo de: " + notification.getRecipient());
        notification.showDetails();
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("- Estado: Enviado (Push) -\n");
    }
}

// 11. Gestor Principal
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
