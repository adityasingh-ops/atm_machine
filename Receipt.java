import java.time.LocalDateTime;

public class Receipt {
    private String transactionType;
    private double amount;
    private String timestamp;

    public Receipt(String transactionType, double amount, String timestamp) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction: " + transactionType + "\nAmount: " + amount + "\nTime: " + timestamp;
    }
}
