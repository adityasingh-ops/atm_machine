package state;

public interface ITransactionState {
    void insertCard();
    void authenticateCard();
    void selectTransactionType();
    void enterAmount();
    void confirmTransaction();
    void dispenseCash();
    void printReceipt();
}
