public interface Keypad {
    String getInput();

    boolean supportsNumeric();

    boolean supportsTouch();
    // Extensible: add RFID, NFC, biometric, etc.
}
