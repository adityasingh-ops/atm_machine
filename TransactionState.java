import java.util.Scanner;

public class TransactionState implements ATMState {
    private ATMContext context;

    public TransactionState(ATMContext context) {
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
        System.out.println("Enter amount to deposit:");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        context.getAccount().deposit(amount);
        context.getTransactionHistory().addTransaction("DEPOSIT", amount);
        System.out.println("Deposit successful. Updated balance: " + context.getAccount().getBalance());
        context.printReceipt();
    }

    @Override
    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        WithdrawalStrategy strategy = context.getWithdrawalStrategy();
        if (strategy.withdraw(context.getNoteDispenser(), amount)) {
            context.getAccount().withdraw(amount);
            context.getTransactionHistory().addTransaction("WITHDRAW", amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.err.println("Withdrawal failed.");
        }
        context.printReceipt();
    }

    @Override
    public void balanceInquiry() {
        context.setState(context.getBalanceInquiryState());
        context.balanceInquiry();
    }

    @Override
    public void miniStatement() {
        context.setState(context.getMiniStatementState());
        context.miniStatement();
    }

    @Override
    public void printReceipt() {
        System.out.println("Printing receipt...");
        Receipt receipt = new Receipt(context.getSelectedTransaction(), context.getLastAmount(),
                java.time.LocalDateTime.now().toString());
        System.out.println(receipt);
    }
}
