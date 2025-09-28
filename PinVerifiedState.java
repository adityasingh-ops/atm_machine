public class PinVerifiedState implements ATMState {
    private ATMContext context;

    public PinVerifiedState(ATMContext context) {
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
        System.out.println("Transaction selected.");
        context.setState(context.getTransactionState());
    }

    @Override
    public void deposit() {
        System.err.println("Select transaction first.");
    }

    @Override
    public void withdraw() {
        System.err.println("Select transaction first.");
    }

    @Override
    public void balanceInquiry() {
        System.err.println("Select transaction first.");
    }

    @Override
    public void miniStatement() {
        System.err.println("Select transaction first.");
    }

    @Override
    public void printReceipt() {
        System.err.println("No transaction to print.");
    }
}
