import java.util.List;

public class MiniStatementState implements ATMState {
    private ATMContext context;

    public MiniStatementState(ATMContext context) {
        this.context = context;
    }

    @Override
    public void insertCard() {
        System.err.println("Card already inserted.");
    }

    @Override
    public void removeCard() {
        System.out.println("Card removed.");
        context.setState(context.getIdleState());
    }

    @Override
    public void enterPin() {
        System.err.println("PIN already verified.");
    }

    @Override
    public void selectTransaction() {
        System.err.println("Transaction already selected.");
    }

    @Override
    public void deposit() {
        System.err.println("Not a deposit transaction.");
    }

    @Override
    public void withdraw() {
        System.err.println("Not a withdrawal transaction.");
    }

    @Override
    public void balanceInquiry() {
        System.err.println("Not a balance inquiry transaction.");
    }

    @Override
    public void miniStatement() {
        List<TransactionHistory.Transaction> transactions = context.getTransactionHistory().getLastNTransactions(5);
        System.out.println("=== Mini Statement (Last 5 Transactions) ===");
        for (TransactionHistory.Transaction t : transactions) {
            System.out.println(t.type + " | " + t.amount + " | " + t.timestamp);
        }
        context.printReceipt();
        context.setState(context.getPinVerifiedState());
    }

    @Override
    public void printReceipt() {
        Receipt receipt = new Receipt("MINI STATEMENT", 0, java.time.LocalDateTime.now().toString());
        System.out.println(receipt);
    }
}
