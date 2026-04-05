package org.zaidism.design.lld.solid;

// ==========================
// OCP FOLLOWED (GOOD DESIGN)
// ==========================

interface DiscountStrategy {
    double calculate(double amount);
}

class CardDiscount implements DiscountStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.10;
    }
}

class UPIDiscount implements DiscountStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.05;
    }
}

// ==========================
// MAIN CLASS (DEMO)
// ==========================

public class OpenClose {

    public static void main(String[] args) {

        // OCP FOLLOWED
        DiscountStrategy cardDiscount = new CardDiscount();
        DiscountStrategy upiDiscount = new UPIDiscount();

        System.out.println("Card Discount: " + cardDiscount.calculate(1000));
        System.out.println("UPI Discount: " + upiDiscount.calculate(1000));
    }

    // ==========================
    // OCP VIOLATION (BAD DESIGN)
    // ==========================
    
    public double calculateDiscount(String paymentType, double amount) {

        if (paymentType.equals("CARD")) {
            return amount * 0.10;

        } else if (paymentType.equals("UPI")) {
            return amount * 0.05;

        } else {
            return 0;
        }
    }
}
