import java.util.*;

public class DynamicProgrammingWithdrawalStrategy implements WithdrawalStrategy {
    @Override
    public boolean withdraw(NoteDispenser dispenser, int amount) {
        List<Note> notes = dispenser.getAvailableNotes();
        int[] denoms = notes.stream().mapToInt(Note::getDenomination).toArray();

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        int[] prev = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        Arrays.fill(prev, -1);

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < denoms.length; j++) {
                if (denoms[j] <= i && dp[i - denoms[j]] != max) {
                    if (dp[i - denoms[j]] + 1 < dp[i]) {
                        dp[i] = dp[i - denoms[j]] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        if (dp[amount] == max) {
            System.err.println("Cannot dispense exact amount with available denominations.");
            return false;
        }

        Map<Integer, Integer> noteCountMap = new HashMap<>();
        int rem = amount;
        while (rem > 0) {
            int idx = prev[rem];
            int denom = denoms[idx];
            noteCountMap.put(denom, noteCountMap.getOrDefault(denom, 0) + 1);
            rem -= denom;
        }

        for (Map.Entry<Integer, Integer> entry : noteCountMap.entrySet()) {
            int denom = entry.getKey();
            int countNeeded = entry.getValue();
            Note note = dispenser.findNoteByDenomination(denom);
            if (note == null || note.getCount() < countNeeded) {
                System.err.println("Insufficient notes of denomination " + denom);
                return false;
            }
        }

        System.out.println("Dispensing notes:");
        for (Map.Entry<Integer, Integer> entry : noteCountMap.entrySet()) {
            int denom = entry.getKey();
            int countToDispense = entry.getValue();
            Note note = dispenser.findNoteByDenomination(denom);
            note.setCount(note.getCount() - countToDispense);
            System.out.println(countToDispense + " x " + denom);
        }

        return true;
    }
}
