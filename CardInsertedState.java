public class CardInsertedState implements ATMState {
    private ATMContext context;

    public CardInsertedState(ATMContext context) {
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
        System.out.println("PIN verified.");
        context.setState(context.getPinVerifiedState());
    }

    @Override
    public void selectTransaction() {
        System.err.println("Enter PIN first.");
    }

    @Override
    public void deposit() {
        System.err.println("Enter PIN first.");
    }

    @Override
    public void withdraw() {
        System.err.println("Enter PIN first.");
    }

    @Override
    public void balanceInquiry() {
        System.err.println("Enter PIN first.");
    }

    @Override
    public void miniStatement() {
        System.err.println("Enter PIN first.");
    }

    @Override
    public void printReceipt() {
        System.err.println("No transaction to print.");
    }
}
