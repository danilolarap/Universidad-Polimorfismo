package models;

import java.util.Date;

// Clase abstracta base
public abstract class Notification {
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
