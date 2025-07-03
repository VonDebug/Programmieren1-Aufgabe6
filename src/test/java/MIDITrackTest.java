import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MIDITrackTest {
    @Test
    public void midiTrack() {
        Exception e = assertThrows(Exception.class, () -> new MIDITrack("C2 D2 F''#1", (byte)20, (byte)20, "An imaginary pan flute"));
        assertEquals("Unbekanntes Instrument 'An imaginary pan flute'.", e.getMessage());
    }
}
