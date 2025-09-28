public class Account {
    private double balance;

    public Account(double openingBalance) {
        this.balance = openingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.err.println("Insufficient funds.");
        }
    }
}
