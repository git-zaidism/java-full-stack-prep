package org.zaidism.design.lld.solid;

interface ShipmentPriceCalculator {
    double calculate(double shipmentWeight);
}

class FXEShipment implements ShipmentPriceCalculator {

    @Override
    public double calculate(double shipmentWeight) {
        return shipmentWeight * 9;
    }
}

class FXGShipment implements ShipmentPriceCalculator {

    @Override
    public double calculate(double shipmentWeight) {
        return shipmentWeight * 5;
    }
}

public class OpenClose {
    public static void main(String[] args) {
        //below direct object creation can be replaced by factory design pattern
        //ignoring this as this is just a demo
        ShipmentPriceCalculator groundShipment = new FXGShipment();
        ShipmentPriceCalculator expressShipment = new FXEShipment();
        expressShipment.calculate(12);
        groundShipment.calculate(10);
    }

    // violation of ocp above code solves this problem
    public double calculate(Object shipmentType, double shipmentWeight) {

        if (shipmentType instanceof FXEShipment) {
            return shipmentWeight * 9;

        } else if (shipmentType instanceof FXGShipment) {
            return shipmentWeight * 5;

        } else {
            return 0;
        }
    }
}
