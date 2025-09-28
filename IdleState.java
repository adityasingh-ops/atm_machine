public class IdleState implements ATMState {
    private ATMContext context;

    public IdleState(ATMContext context) {
        this.context = context;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        context.setState(context.getCardInsertedState());
    }

    @Override
    public void removeCard() {
        System.err.println("No card to remove.");
    }

    @Override
    public void enterPin() {
        System.err.println("No card. Can't enter pin.");
    }

    @Override
    public void selectTransaction() {
        System.err.println("No card. No transaction.");
    }

    @Override
    public void deposit() {
        System.err.println("No card. Can't deposit.");
    }

    @Override
    public void withdraw() {
        System.err.println("No card. Can't withdraw.");
    }

    @Override
    public void balanceInquiry() {
        System.err.println("No card. Can't check balance.");
    }

    @Override
    public void miniStatement() {
        System.err.println("No card. Can't get statement.");
    }

    @Override
    public void printReceipt() {
        System.err.println("No card. Can't print receipt.");
    }
}
