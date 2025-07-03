import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MIDIFileTest {
    @Test
    void writeMIDIFile() {
        try {
            File tmpfile = File.createTempFile("outfile", "midi");
            MIDIFile file = null;
            try {
                file = new MIDIFile("melody.txt");
            } catch(Exception e) {
                fail("Instanziierung von MIDIFile mit melody.txt hat zu einer Exception geführt: " + e.getMessage());
            }
            try {
                file.writeMIDIFile(tmpfile.getAbsolutePath());
            } catch (Exception e) {
                fail("writeMIDIFile nach Instanziierung mit melody.txt hat zu einer Exception geführt: " + e.getMessage());
            }
            try {
                FileInputStream inputStream = new FileInputStream(tmpfile);
                byte[] data = new byte[(int)tmpfile.length()];
                inputStream.read(data);
                inputStream.close();
                File referenceFile = new File("src/test/resources/reference.midi");
                inputStream = new FileInputStream(referenceFile);
                byte[] referencedata = new byte[(int)referenceFile.length()];
                inputStream.read(referencedata);
                inputStream.close();
                assertArrayEquals(referencedata, data, "Ausgabe-MIDI-datei basierend auf melody.txt ist nicht identisch mit erwarteter Ausgabe-MIDI-Datei.");
            } catch (IOException e) { }
        } catch(IOException e) {
        }
    }

    @Test
    void getBytes() {
        try {
            MIDIFile file = new MIDIFile("melody.txt");
            assertIterableEquals(
                    new ArrayList<Byte>(Arrays.asList(new Byte[] {(byte)0x4d, (byte)0x54, (byte)0x68, (byte)0x64, (byte)0x0, (byte)0x0, (byte)0x0, (byte)0x6, (byte)0x0, (byte)0x0, (byte)0x0, (byte)0x1, (byte)0x0, (byte)0x32, (byte)0x4d, (byte)0x54, (byte)0x72, (byte)0x6b, (byte)0x0, (byte)0x0, (byte)0x0, (byte)0xffffffa2, (byte)0x0, (byte)0xffffffff, (byte)0x58, (byte)0x4, (byte)0x4, (byte)0x2, (byte)0x18, (byte)0x8, (byte)0x0, (byte)0xffffffff, (byte)0x51, (byte)0x3, (byte)0x7, (byte)0xffffffa1, (byte)0x20, (byte)0x0, (byte)0xffffffc0, (byte)0x1, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x2d, (byte)0x3c, (byte)0x3c, (byte)0xffffff80, (byte)0x2d, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0xf, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x2d, (byte)0x3c, (byte)0x3c, (byte)0xffffff80, (byte)0x2d, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0xf, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x35, (byte)0x3c, (byte)0x3c, (byte)0xffffff80, (byte)0x35, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0xf, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x1e, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x2d, (byte)0x3c, (byte)0x3c, (byte)0xffffff80, (byte)0x2d, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x34, (byte)0x3c, (byte)0xf, (byte)0xffffff80, (byte)0x34, (byte)0x3c, (byte)0x0, (byte)0xffffff90, (byte)0x30, (byte)0x3c, (byte)0x3c, (byte)0xffffff80, (byte)0x30, (byte)0x3c, (byte)0xffffffff, (byte)0x2f, (byte)0x0})),
                    file.getBytes()
            );
        } catch (Exception e) {

        }
    }

    @Test
    void wrongInstrument() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("wrongInstrument.txt"));
        assertEquals("Fehler in Datei wrongInstrument.txt: Unbekanntes Instrument 'My awesome air guitar'.", e.getMessage());
    }

    @Test
    void inexistentFile() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("thisdoesnotexist.txt"));
        assertEquals("Fehler beim Einlesen der Datei thisdoesnotexist.txt.", e.getMessage());
    }

    @Test
    void missingSpeed() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("nospeed.txt"));
        assertEquals("Fehler in Datei nospeed.txt: 'Speed: x' muss angegeben sein, mit x != 0.", e.getMessage());
    }

    @Test
    void missingDefaultNoteDuration() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("noduration.txt"));
        assertEquals("Fehler in Datei noduration.txt: 'Full note duration: x' muss angegeben sein, mit x != 0.", e.getMessage());
    }

    @Test
    void missingInstrument() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("noinstrument.txt"));
        assertEquals("Fehler in Datei noinstrument.txt: 'Instrument: x' muss angegeben sein.", e.getMessage());
    }

    @Test
    void missingVelocity() {
        Exception e = assertThrows(Exception.class, () -> new MIDIFile("novelocity.txt"));
        assertEquals("Fehler in Datei novelocity.txt: 'Velocity: x' muss angegeben sein, mit x != 0.", e.getMessage());
    }
}