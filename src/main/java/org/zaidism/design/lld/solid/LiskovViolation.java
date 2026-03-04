package org.zaidism.design.lld.solid;

abstract class NotificationV2 {
    abstract void sendNotification(String msg, String email);
}

class EmailNotificationV2 extends NotificationV2 {

    @Override
    void sendNotification(String msg, String email) {
        System.out.println("Message sent to email" + msg + " "+email);
    }
}

class WhatsAppNotificationV2 extends NotificationV2 {

    @Override
    void sendNotification(String msg, String email) {
        throw new UnsupportedOperationException("Email NOtification not supported");
    }
}

public class LiskovViolation {

    public static void main(String[] args) {
        NotificationV2 emailNotification = new EmailNotificationV2();
        emailNotification.sendNotification("email notification...", "jahidquhr3@gmail.com");

        NotificationV2 whatsAppNotification = new WhatsAppNotificationV2();
        whatsAppNotification.sendNotification("whats app notification..", "3478438974938");
    }

}

