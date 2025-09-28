public class Keyboard implements Keypad {
    public String getInput() {
        return "";
    } // Override for real device

    public boolean supportsNumeric() {
        return true;
    }

    public boolean supportsTouch() {
        return false;
    }
}
