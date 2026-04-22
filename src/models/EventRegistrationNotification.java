package models;

import java.util.Date;

// Situacion Especializada
public class EventRegistrationNotification extends Notification {
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
