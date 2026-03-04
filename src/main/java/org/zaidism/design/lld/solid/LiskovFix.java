package org.zaidism.design.lld.solid;

abstract class Notification {
    abstract void sendNotification(String msg);
}

class EmailNotification extends Notification {
    @Override
    public void sendNotification(String msg) {
        System.out.println("Email: " + msg);
    }
}

class WhatsAppNotification extends Notification {
    @Override
    public void sendNotification(String msg) {
        System.out.println("WhatsApp: " + msg);
    }
}

public class LiskovFix {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        emailNotification.sendNotification("email notification...");

        Notification whatsAppNotification = new WhatsAppNotification();
        whatsAppNotification.sendNotification("whats app notification..");

    }
}
