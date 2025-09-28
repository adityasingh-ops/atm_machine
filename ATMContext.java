import java.util.Scanner;

public class ATMContext {
    // State references
    private ATMState idleState;
    private ATMState cardInsertedState;
    private ATMState pinVerifiedState;
    private ATMState transactionState;
    private ATMState balanceInquiryState;
    private ATMState miniStatementState;

    // Current state
    private ATMState currentState;

    // Transaction properties
    private String selectedTransaction;
    private double lastAmount;

    // Components
    private NoteDispenser noteDispenser;
    private WithdrawalStrategy withdrawalStrategy;
    private Account account;
    private TransactionHistory transactionHistory;
    private Keypad keypad;

    public ATMContext() {
        // Initialize all states
        idleState = new IdleState(this);
        cardInsertedState = new CardInsertedState(this);
        pinVerifiedState = new PinVerifiedState(this);
        transactionState = new TransactionState(this);
        balanceInquiryState = new BalanceInquiryState(this);
        miniStatementState = new MiniStatementState(this);
        currentState = idleState; // Start in Idle

        // Initialize core components
        noteDispenser = new NoteDispenser();
        withdrawalStrategy = new DynamicProgrammingWithdrawalStrategy();
        account = new Account(5000.0); // Example balance
        transactionHistory = new TransactionHistory();
        keypad = new Keyboard(); // Default: numpad
    }

    // State getters
    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getCardInsertedState() {
        return cardInsertedState;
    }

    public ATMState getPinVerifiedState() {
        return pinVerifiedState;
    }

    public ATMState getTransactionState() {
        return transactionState;
    }

    public ATMState getBalanceInquiryState() {
        return balanceInquiryState;
    }

    public ATMState getMiniStatementState() {
        return miniStatementState;
    }

    // State setter
    public void setState(ATMState state) {
        currentState = state;
    }

    public ATMState getState() {
        return currentState;
    }

    // Transaction properties
    public String getSelectedTransaction() {
        return selectedTransaction;
    }

    public void setSelectedTransaction(String selectedTransaction) {
        this.selectedTransaction = selectedTransaction;
    }

    public double getLastAmount() {
        return lastAmount;
    }

    public void setLastAmount(double lastAmount) {
        this.lastAmount = lastAmount;
    }

    // Component access
    public NoteDispenser getNoteDispenser() {
        return noteDispenser;
    }

    public WithdrawalStrategy getWithdrawalStrategy() {
        return withdrawalStrategy;
    }

    public void setWithdrawalStrategy(WithdrawalStrategy withdrawalStrategy) {
        this.withdrawalStrategy = withdrawalStrategy;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public Keypad getKeypad() {
        return keypad;
    }

    public void setKeypad(Keypad keypad) {
        this.keypad = keypad;
    }

    // Delegated ATM operations
    public void insertCard() {
        currentState.insertCard();
    }

    public void removeCard() {
        currentState.removeCard();
    }

    public void enterPin() {
        currentState.enterPin();
    }

    public void selectTransaction() {
        currentState.selectTransaction();
    }

    public void deposit() {
        currentState.deposit();
    }

    public void withdraw() {
        currentState.withdraw();
    }

    public void balanceInquiry() {
        currentState.balanceInquiry();
    }

    public void miniStatement() {
        currentState.miniStatement();
    }

    public void printReceipt() {
        currentState.printReceipt();
    }

    // Main ATM loop
    public void runATM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ATM ready.");

        while (true) {
            System.out.println("\nCurrent state: " + currentState.getClass().getSimpleName());
            System.out.println(
                    "Options: [1]insert card, [2]remove card, [3]enter pin, [4]select transaction, [5]deposit, [6]withdraw, [7]balance inquiry, [8]mini statement, [9]print receipt, [0]exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertCard();
                    break;
                case 2:
                    removeCard();
                    break;
                case 3:
                    enterPin();
                    break;
                case 4: {
                    System.out.println("Select transaction (deposit/withdraw/balance/mini):");
                    String txn = scanner.next();
                    setSelectedTransaction(txn);
                    selectTransaction();
                    break;
                }
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    balanceInquiry();
                    break;
                case 8:
                    miniStatement();
                    break;
                case 9:
                    printReceipt();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice.");
            }
        }
    }
}
