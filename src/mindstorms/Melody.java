package mindstorms;

import java.util.LinkedHashMap;
import ch.aplu.ev3.*;
/**
 * Melody
 */
public class Melody {
	LegoRobot robot;
	int duration = 300;
    enum Note {
        C(261),
        D(293),
        E(329),
        F(349),
        G(392),
        Ab(415),
        A(440),
        B(493);

        int freq;

        Note(int freq) {
            this.freq = freq;
        }
    }
    static final LinkedHashMap<String,int[]> songs;
    static {
    	songs = new LinkedHashMap<>();
    	songs.put("littleroot", new int[] {Note.C.freq, Note.F.freq, Note.G.freq, Note.Ab.freq, Note.A.freq, Note.C.freq, Note.F.freq, Note.G.freq, Note.Ab.freq, Note.C.freq, Note.F.freq, Note.G.freq});
    	songs.put("simple", new int[] {Note.C.freq, Note.D.freq, Note.E.freq, Note.C.freq, Note.E.freq, Note.D.freq, Note.C.freq});
    }
    String[] titles = {"littleroot", "simple"};

    public Melody() {
        robot = new LegoRobot();
        int i = 0;
        for (String title: songs.keySet()) {
        	robot.drawString(title, 3, i);
        	i++;
        }
        int selected = 0;
        do {
        Tools.waitButton();
        robot.drawString(" ", 1, selected + 1);
        if (robot.isDownHit()) {
        	selected++;
        	robot.drawString("X", 1, selected + 1);

        } else if (robot.isUpHit()) {
        	selected--;
        	robot.drawString("X", 1, selected + 1);
        }
        } while(!robot.isEnterHit());
        for (int freq : songs.get(titles[selected])) {
            robot.playTone(freq, duration);
            try {
                Thread.sleep(100); // Short pause between notes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        robot.exit();
    }
    public static void main(String[] args) {
        new Melody();
    }
}
