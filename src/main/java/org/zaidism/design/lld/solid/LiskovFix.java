package org.zaidism.design.lld.solid;

abstract class ShipmentV2 {
    abstract void currentShipmentStatus();
}

interface AddressDeliverable {
    void deliverToAddress(String address);
}

class StandardShipmentV2 extends ShipmentV2 implements AddressDeliverable {

    @Override
    void currentShipmentStatus() {
        System.out.println("Standard shipment in transit");
    }

    @Override
    public void deliverToAddress(String address) {
        System.out.println("Delivered to " + address);
    }
}

class HoldAtLocationShipmentV2 extends ShipmentV2 {

    @Override
    void currentShipmentStatus() {
        System.out.println("Waiting for customer pickup");
    }
}
public class LiskovFix {
    public static void main(String[] args) {
        // this is also possible supports liskov AddressDeliverable standard = new StandardShipmentV2();
        StandardShipmentV2 standard = new StandardShipmentV2();
        standard.deliverToAddress("some address");

        // this is also possible supports liskov ShipmentV2 hold = new HoldAtLocationShipmentV2();
        HoldAtLocationShipmentV2 hold = new HoldAtLocationShipmentV2();
        hold.currentShipmentStatus();
    }
}
