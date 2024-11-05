package com.flipfit.business;

public class PaymentsImpl implements Payments{
    public void makePayment() {
        System.out.println("Payment made successfully");
    }

    public void displayTransactions(int userId) {
        System.out.println("Transactions displayed successfully");
    }
}
