import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            MIDIFile midiFile = new MIDIFile("melody.txt");
            printList(midiFile.getBytes());
            midiFile.writeMIDIFile("melody.midi");
        } catch(Exception e) {
            System.out.println("FEHLER: " + e.getMessage());
        }
    }
}
