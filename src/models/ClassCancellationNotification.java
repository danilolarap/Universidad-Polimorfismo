package models;

import java.util.Date;

// Situacion Especializada
public class ClassCancellationNotification extends Notification {
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
