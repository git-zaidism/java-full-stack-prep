package org.zaidism.design.lld.solid;

abstract class Shipment {
    abstract void deliverToAddress(String address);
    abstract void currentShipmentStatus();
}

class StandardShipment extends Shipment {

    @Override
    void deliverToAddress(String address) {
        System.out.println("shipment delivered to address" + address);
    }

    @Override
    void currentShipmentStatus() {
        System.out.println("current shipment status is...");
    }
}

class HoldAtLocationShipment extends Shipment {

    @Override
    void deliverToAddress(String address) {
        throw new UnsupportedOperationException("Cannot deliver to address. Shipment is Hold At Location.");
    }

    @Override
    void currentShipmentStatus() {
        System.out.println("current shipment status is...");
    }
}

public class LiskovViolation {
    public static void main(String[] args) {
        StandardShipment standardShipment = new StandardShipment();
        HoldAtLocationShipment holdAtLocationShipment = new HoldAtLocationShipment();
            standardShipment.deliverToAddress("Jan Street");
        holdAtLocationShipment.deliverToAddress("Jan Street");
    }
}
