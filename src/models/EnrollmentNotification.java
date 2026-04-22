package models;

import java.util.Date;

// Situacion Especializada
public class EnrollmentNotification extends Notification {
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
