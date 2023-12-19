package dev.lpa;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        } else {
            System.out.println("Branch " + branchName + " already exists.");
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            if (branch.newCustomer(customerName, initialTransaction)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            if(branch.addCustomerTransaction(customerName, transaction)) {
                return true;
            }
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {

            for (Customer customer: branch.getCustomers()) {
                System.out.println(customer.getName());
                if (printTransactions) {
                    System.out.println(customer.getTransactions());
                }
            }
            return true;

        }
        return false;
    }

}
