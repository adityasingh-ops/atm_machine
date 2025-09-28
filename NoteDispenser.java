import java.util.*;

public class NoteDispenser extends CashDispenser {
    private List<Note> notes;

    public NoteDispenser() {
        notes = new ArrayList<>();
        notes.add(new Note(2000, 10));
        notes.add(new Note(500, 20));
        notes.add(new Note(200, 30));
        notes.add(new Note(100, 40));
        notes.add(new Note(50, 50));
        notes.add(new Note(20, 100));
        notes.add(new Note(10, 200));
    }

    public Note findNoteByDenomination(int denom) {
        for (Note note : notes) {
            if (note.getDenomination() == denom)
                return note;
        }
        return null;
    }

    @Override
    public boolean dispense(double amount) {
        // To be used by strategies, not directly here
        return false;
    }

    @Override
    public List<Note> getAvailableNotes() {
        return new ArrayList<>(notes);
    }
}
