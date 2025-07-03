import java.util.ArrayList;
import java.util.Arrays;

public class MIDIFile {
    private MIDITrack track;
    private byte speed;

    public MIDIFile(MIDITrack track, byte speed) {
        this.track = track;
        this.speed = speed;
    }

    private ArrayList<Byte> getHeader() {
        Byte[] header = new Byte[] {0x4D, 0x54, 0x68, 0x64, 0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x01, 0x00, speed};
        return new ArrayList<Byte>(Arrays.asList(header));
    }

    public ArrayList<Byte> getBytes() {
        ArrayList<Byte> res = getHeader();
        res.addAll(track.getTrack());
        return res;
    }
}
