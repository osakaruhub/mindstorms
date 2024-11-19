package mindstorms;
import ch.aplu.ev3.*;
/**
 * Melody
 */
public class Melody {
    enum Note {
        C(261),
        D(293),
        E(329),
        F(349),
        G(392),
        Ab(415),
        A(440),
        B(493);

        private int freq;

        Note(int freq) {
            this.freq = freq;
        }
    }

    final int[12] littleRoot = {Note.C.freq, Note.F.freq, Note.G.freq, Note.Ab.freq, Note.A.freq, Note.C.freq, Note.F.freq, Note.G.freq, Note.Ab.freq, Note.C.freq, Note.F.freq, Note.G.freq}
    final int[7] simple = {Note.C.freq, Note.D.freq, Note.E.freq, Note.C.freq, Note.E.freq, Note.D.freq, Note.C.freq}

    public Melody() {
        LegoRobot robot = new LegoRobot();

        for (int freq : simple) {
            robot.playTone(freq, duration);
            try {
                Thread.sleep(100); // Short pause between notes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Melody();
    }
}
