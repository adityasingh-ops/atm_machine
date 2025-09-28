import java.util.*;

public class TransactionHistory {
    public static class Transaction {
        public String type;
        public double amount;
        public String timestamp;

        public Transaction(String type, double amount, String timestamp) {
            this.type = type;
            this.amount = amount;
            this.timestamp = timestamp;
        }
    }

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(String type, double amount) {
        String timestamp = java.time.LocalDateTime.now().toString();
        transactions.add(new Transaction(type, amount, timestamp));
    }

    public List<Transaction> getLastNTransactions(int n) {
        int size = transactions.size();
        if (size < n)
            return new ArrayList<>(transactions);
        return transactions.subList(size - n, size);
    }
}
