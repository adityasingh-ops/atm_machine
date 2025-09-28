import java.util.List;

public abstract class CashDispenser {
    public abstract boolean dispense(double amount);

    public abstract List<Note> getAvailableNotes();
}
