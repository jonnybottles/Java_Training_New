public class Main {
    public static void main(String[] args) {
        BankAccount theBankAccount = new BankAccount();
        theBankAccount.depositFunds(100);
        theBankAccount.withdrawFunds(50);
        theBankAccount.withdrawFunds(100);
        System.out.println("Ending balance: " + theBankAccount.getAccountBalance());
    }
}