//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.lpa;

public class BankAccount {
    private double balance;
    private String name;
    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        synchronized(this.lockName) {
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Deposit - Talking to the teller at the bank...");
            Thread.sleep(7000L);
        } catch (InterruptedException var8) {
            throw new RuntimeException(var8);
        }

        synchronized(this.lockBalance) {
            double origBalance = this.balance;
            this.balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f) : NEW BALANCE = %.0f%n", origBalance, amount, this.balance);
            this.addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount) {
        if (amount >= 5000.0) {
            synchronized(this.lockBalance) {
                System.out.println("Congratulations, you earned a promotional deposit.");
                this.balance += 25.0;
            }
        }

    }

    public synchronized void withdraw(double amount) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException var5) {
            throw new RuntimeException(var5);
        }

        double origBalance = this.balance;
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) : NEW BALANCE = %.0f%n", origBalance, amount, this.balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f): INSUFFICIENT FUNDS!", origBalance, amount);
        }

    }
}
