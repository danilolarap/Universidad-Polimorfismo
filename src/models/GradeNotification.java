package models;

import java.util.Date;

// Situacion Especializada
public class GradeNotification extends Notification {
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
