import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MIDITrack {
    private byte instrument;
    private ArrayList<Note> notes = new ArrayList<>();

    public MIDITrack(String melody) {
        String[] parts = melody.split(";");
        byte defaultVelocity = (byte)Integer.parseInt(parts[0]);
        byte fullNoteDuration = (byte)Integer.parseInt(parts[1]);
        System.out.println(parts[2]);
        this.instrument = (byte)(int)(getInstruments().get(parts[2]));
        System.out.println(parts[3].split(" ").length);
        for(String part : parts[3].split(" ")) {
            this.notes.add(new Note(part, fullNoteDuration, defaultVelocity));
        }
        System.out.println(this.notes.size());
    }

    private HashMap<String, Integer> getInstruments() {
        HashMap<String, Integer> res = new HashMap<>();
        String data = "1.\tAcoustic Grand Piano\n" +
                "2.\tBright Acoustic Piano\n" +
                "3.\tElectric Grand Piano\n" +
                "4.\tHonky-tonk Piano\n" +
                "5.\tElectric Piano 1 (Rhodes Piano)\n" +
                "6.\tElectric Piano 2 (Chorused Piano)\n" +
                "7.\tHarpsichord\n" +
                "8.\tClavinet\n" +
                "9.\tCelesta\n" +
                "10.\tGlockenspiel\n" +
                "11.\tMusic Box\n" +
                "12.\tVibraphone\n" +
                "13.\tMarimba\n" +
                "14.\tXylophone\n" +
                "15.\tTubular Bells\n" +
                "16.\tDulcimer (Santur)\n" +
                "17.\tDrawbar Organ (Hammond)\n" +
                "18.\tPercussive Organ\n" +
                "19.\tRock Organ\n" +
                "20.\tChurch Organ\n" +
                "21.\tReed Organ\n" +
                "22.\tAccordion (French)\n" +
                "23.\tHarmonica\n" +
                "24.\tTango Accordion (Band neon)\n" +
                "25.\tAcoustic Guitar (nylon)\n" +
                "26.\tAcoustic Guitar (steel)\n" +
                "27.\tElectric Guitar (jazz)\n" +
                "28.\tElectric Guitar (clean)\n" +
                "29.\tElectric Guitar (muted)\n" +
                "30.\tOverdriven Guitar\n" +
                "31.\tDistortion Guitar\n" +
                "32.\tGuitar harmonics\n" +
                "33.\tAcoustic Bass\n" +
                "34.\tElectric Bass (fingered)\n" +
                "35.\tElectric Bass (picked)\n" +
                "36.\tFretless Bass\n" +
                "37.\tSlap Bass 1\n" +
                "38.\tSlap Bass 2\n" +
                "39.\tSynth Bass 1\n" +
                "40.\tSynth Bass 2\n" +
                "41.\tViolin\n" +
                "42.\tViola\n" +
                "43.\tCello\n" +
                "44.\tContrabass\n" +
                "45.\tTremolo Strings\n" +
                "46.\tPizzicato Strings\n" +
                "47.\tOrchestral Harp\n" +
                "48.\tTimpani\n" +
                "49.\tString Ensemble 1 (strings)\n" +
                "50.\tString Ensemble 2 (slow strings)\n" +
                "51.\tSynthStrings 1\n" +
                "52.\tSynthStrings 2\n" +
                "53.\tChoir Aahs\n" +
                "54.\tVoice Oohs\n" +
                "55.\tSynth Voice\n" +
                "56.\tOrchestra Hit\n" +
                "57.\tTrumpet\n" +
                "58.\tTrombone\n" +
                "59.\tTuba\n" +
                "60.\tMuted Trumpet\n" +
                "61.\tFrench Horn\n" +
                "62.\tBrass Section\n" +
                "63.\tSynthBrass 1\n" +
                "64.\tSynthBrass 2\n" +
                "65.\tSoprano Sax\n" +
                "66.\tAlto Sax\n" +
                "67.\tTenor Sax\n" +
                "68.\tBaritone Sax\n" +
                "69.\tOboe\n" +
                "70.\tEnglish Horn\n" +
                "71.\tBassoon\n" +
                "72.\tClarinet\n" +
                "73.\tPiccolo\n" +
                "74.\tFlute\n" +
                "75.\tRecorder\n" +
                "76.\tPan Flute\n" +
                "77.\tBlown Bottle\n" +
                "78.\tShakuhachi\n" +
                "79.\tWhistle\n" +
                "80.\tOcarina\n" +
                "81.\tLead 1 (square wave)\n" +
                "82.\tLead 2 (sawtooth wave)\n" +
                "83.\tLead 3 (calliope)\n" +
                "84.\tLead 4 (chiffer)\n" +
                "85.\tLead 5 (charang)\n" +
                "86.\tLead 6 (voice solo)\n" +
                "87.\tLead 7 (fifths)\n" +
                "88.\tLead 8 (bass + lead)\n" +
                "89.\tPad 1 (new age Fantasia)\n" +
                "90.\tPad 2 (warm)\n" +
                "91.\tPad 3 (polysynth)\n" +
                "92.\tPad 4 (choir space voice)\n" +
                "93.\tPad 5 (bowed glass)\n" +
                "94.\tPad 6 (metallic pro)\n" +
                "95.\tPad 7 (halo)\n" +
                "96.\tPad 8 (sweep)\n" +
                "97.\tFX 1 (rain)\n" +
                "98.\tFX 2 (soundtrack)\n" +
                "99.\tFX 3 (crystal)\n" +
                "100.\tFX 4 (atmosphere)\n" +
                "101.\tFX 5 (brightness)\n" +
                "102.\tFX 6 (goblins)\n" +
                "103.\tFX 7 (echoes, drops)\n" +
                "104.\tFX 8 (sci-fi, star theme)\n" +
                "105.\tSitar\n" +
                "106.\tBanjo\n" +
                "107.\tShamisen\n" +
                "108.\tKoto\n" +
                "109.\tKalimba\n" +
                "110.\tBag pipe\n" +
                "111.\tFiddle\n" +
                "112.\tShanai\n" +
                "113.\tTinkle Bell\n" +
                "114.\tAgogo\n" +
                "115.\tSteel Drums\n" +
                "116.\tWoodblock\n" +
                "117.\tTaiko Drum\n" +
                "118.\tMelodic Tom\n" +
                "119.\tSynth Drum\n" +
                "120.\tReverse Cymbal\n" +
                "121.\tGuitar Fret Noise\n" +
                "122.\tBreath Noise\n" +
                "123.\tSeashore\n" +
                "124.\tBird Tweet\n" +
                "125.\tTelephone Ring\n" +
                "126.\tHelicopter\n" +
                "127.\tApplause\n" +
                "128.\tGunshot";
        String[] datsplit = data.split("\n");
        for(String s : datsplit) {
            String[] datapoint = s.split(".\t");
            res.put(datapoint[1], Integer.parseInt(datapoint[0]));
        }
        return res;
    }

    public ArrayList<Byte> getTrack() {
        ArrayList<Byte> res = getHeader();
        for(Note note : notes) {
            res.addAll(note.getNoteEvents());
        }
        res.add((byte) 0xFF);
        res.add((byte) 0x2F);
        res.add((byte) 0x00);
        return res;
    }

    private ArrayList<Byte> getHeader() {
        Byte[] header = new Byte[] {0x4D, 0x54, 0x72, 0x6B, 0x00, 0x00, 0x00, (byte)(8*notes.size() + 18),
                0x00, (byte)0xFF, 0x58, 0x04, 0x04, 0x02, 0x18, 0x08, 0x00, (byte)0xFF, 0x51, 0x03, 0x07, (byte)0xA1, 0x20,
                0x00, (byte)0xC0, instrument};
        ArrayList<Byte> res = new ArrayList<Byte>(Arrays.asList(header));
        return res;
    }
}
