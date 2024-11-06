/**
 * 
 */
package mindstorms;

import ch.aplu.ev3.Gear;
import ch.aplu.ev3.LegoRobot;

/**
 * @author stuewe.oskar
 *
 */
public class Motoren {
	private int strecke = 3000; // Dauer
	private int drehen = strecke / 2; // 180°
	LegoRobot robot;
	Gear gear;

	public Motoren() {
		robot = new LegoRobot();
		gear = new Gear();
		robot.addPart(gear);
		squares();
		gear.stop();
		robot.exit();
	}

	// 1.
	public void cross() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 4; i++) {
				gear.forward(strecke);
				gear.right(drehen);
				gear.forward(strecke);
				gear.left(drehen / 2); // 90° drehen
			}
		}
	}

	// 2.
	public void bitSin() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 3; i++) {
				gear.forward(strecke);
				gear.right(drehen);
				gear.forward(strecke);
				gear.right(drehen);
				gear.forward(strecke);
				gear.left(drehen);
				gear.forward(strecke);
				gear.right(drehen);
			}
			gear.forward(strecke);
		}
	}

	// 3.
	public void arc() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 3; i++) {
				gear.rightArc(0.2, strecke * 2);
				gear.leftArc(0.2, strecke * 2);
			}
		}
	}

	// 4.
	public void squares() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 4; i++) {
				gear.forward(strecke);
				gear.left(drehen);
				gear.forward(strecke);
				gear.left(drehen);
				gear.forward(strecke);
				gear.right(drehen);
				gear.forward(strecke);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Motoren();
	}

}