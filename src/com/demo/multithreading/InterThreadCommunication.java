package com.demo.multithreading;

public class InterThreadCommunication {

    public static void main(String[] args) {
        final BankClientDemo client = new BankClientDemo();
        new Thread(() -> client.withdrawMoney(3000)).start();
        new Thread(() -> client.depositMoney(2000)).start();
        new Thread() {
            public void run() {
                client.withdrawMoney(2000);
            }
        }.start();
    }
}

class BankClientDemo {
    int balAmount = 5000;

    synchronized void withdrawMoney(int amount) {
        System.out.println("Withdrawing money");
        balAmount -= amount;
        System.out.println("The balance amount is: " + balAmount);
    }

    synchronized void depositMoney(int amount) {
        System.out.println("Depositing money");
        balAmount += amount;
        System.out.println("The balance amount is: " + balAmount);
        notify();
    }
}