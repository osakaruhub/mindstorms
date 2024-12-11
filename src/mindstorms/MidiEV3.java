package mindstorms;

import javax.sound.midi.*;

import ch.aplu.ev3.EV3Properties;
import ch.aplu.ev3.LegoRobot;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidiEV3 {
	static List<int[]> song = new ArrayList<>();


	public static void main (String[] args) {
		Scanner sc = new Scanner("elise.aev");
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			try {
				song.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
			} catch (Exception e) {}
		}
		LegoRobot robot = new LegoRobot();
		for (int[] s: song) {
			System.out.println(s[0] + " " + s[1]);
			robot.playTone(s[0], s[1]);
		}
	}
}