package org.zaidism.design.lld.solid;

public class DependencyInversionDemo {

    // ❌ BAD DESIGN (Violates DIP)
    static class EmailNotificationService {
        public void send(String message) {
            System.out.println("Email sent: " + message);
        }
    }

    // High-level business logic directly depending on low-level implementation
    static class ShipmentServiceBad {

        private EmailNotificationService emailService = new EmailNotificationService();

        public void deliverShipment(String trackingId) {
            System.out.println("Shipment delivered: " + trackingId);

            // Tight coupling to concrete class
            emailService.send("Your shipment " + trackingId + " is delivered.");
        }
    }

    // ✅ GOOD DESIGN (Follows DIP)

    // Abstraction
    interface NotificationService {
        void send(String message);
    }

    // Low-level implementations depend on abstraction
    static class EmailNotificationServiceV2 implements NotificationService {
        @Override
        public void send(String message) {
            System.out.println("Email sent: " + message);
        }
    }

    static class SmsNotificationService implements NotificationService {
        @Override
        public void send(String message) {
            System.out.println("SMS sent: " + message);
        }
    }

    // High-level module depends on abstraction
    static class ShipmentService {

        private NotificationService notificationService;

        public ShipmentService(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        public void deliverShipment(String trackingId) {
            System.out.println("Shipment delivered: " + trackingId);
            notificationService.send("Your shipment " + trackingId + " is delivered.");
        }
    }

    // MAIN METHOD
    // High level : Shipment service represents core logistics behavior. Delivering a shipment is business logic. That’s central to the system. So ShipmentService is high-level.
    // Low-level modules are: Technical details Infrastructure concerns Implementation mechanisms in our ex These are just communication mechanisms.
    public static void main(String[] args) {

        System.out.println("----- BAD DESIGN -----");
        ShipmentServiceBad badService = new ShipmentServiceBad();
        badService.deliverShipment("FX123");

        System.out.println("\n----- GOOD DESIGN -----");

        NotificationService email = new EmailNotificationServiceV2();
        ShipmentService shipmentWithEmail = new ShipmentService(email);
        shipmentWithEmail.deliverShipment("FX456");

        NotificationService sms = new SmsNotificationService();
        ShipmentService shipmentWithSms = new ShipmentService(sms);
        shipmentWithSms.deliverShipment("FX789");
    }
}
