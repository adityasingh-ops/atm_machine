public interface ATMState {
    void insertCard();

    void removeCard();

    void enterPin();

    void selectTransaction();

    void deposit();

    void withdraw();

    void balanceInquiry();

    void miniStatement();

    void printReceipt();
}
