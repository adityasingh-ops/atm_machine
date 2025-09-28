public class BalanceInquiryState implements ATMState {
    private ATMContext context;

    public BalanceInquiryState(ATMContext context) {
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
        System.out.println("Current balance: " + context.getAccount().getBalance());
        context.printReceipt();
        context.setState(context.getPinVerifiedState());
    }

    @Override
    public void miniStatement() {
        System.err.println("Not a statement transaction.");
    }

    @Override
    public void printReceipt() {
        Receipt receipt = new Receipt("BALANCE", 0, java.time.LocalDateTime.now().toString());
        System.out.println(receipt);
    }
}
