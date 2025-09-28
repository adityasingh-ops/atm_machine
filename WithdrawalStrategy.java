public interface WithdrawalStrategy {
    boolean withdraw(NoteDispenser dispenser, int amount);
}
