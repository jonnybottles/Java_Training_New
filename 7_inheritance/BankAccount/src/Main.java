public class Main {
    public static void main(String[] args) {
//        BankAccount theBankAccount = new BankAccount("12345", 1000.00, "Bob Brown",
//                "myemail@bob.com", "760-555-5555");
                BankAccount theBankAccount = new BankAccount();
//        theBankAccount.depositFunds(100);
//        theBankAccount.withdrawFunds(50);
//        theBankAccount.withdrawFunds(100);
        System.out.println("Ending balance: " + theBankAccount.getAccountBalance());
    }
}