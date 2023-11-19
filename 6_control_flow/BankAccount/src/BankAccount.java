public class BankAccount {

    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        System.out.println("Empty constructor called");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amt) {
        this.accountBalance += amt;
        System.out.println("Successfully deposited $" + amt);
        System.out.println(("New Account Balance: $" + getAccountBalance()));
    }

    public void withdrawFunds(double amt) {
        if ((this.accountBalance - amt) < 0) {
            System.out.println("Insufficient funds. ");
            return;
        }

        this.accountBalance -= amt;
        System.out.println("Successfully withdrew $" + amt);
        System.out.println(("New Account Balance: $" + getAccountBalance()));
    }
}
