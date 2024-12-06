/**
 * Motoren
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Motoren {
	private static final int STRECKE = 3000; // Dauer
	private static final int DREHEN = 700; // 90 Grad
	LegoRobot robot;
	Gear gear;

    // init
	public Motoren() {
		robot = new LegoRobot();
		gear = new Gear();
		robot.addPart(gear);
        // add method calls here
		robot.exit();
	}

	// 1.
	public void cross() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 4; i++) { // faehrt nach vorne, dreht sich um und faehrt wieder zum Ausgangspunkt. dies macht er mit jeder kardinalen Richtung 
				gear.forward(STRECKE);
				gear.right(DREHEN * 2); // 180 Grad
				gear.forward(STRECKE);
				gear.left(DREHEN);
            }
		}
	}

	// 2.
	public void squareWave() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 3; i++) { // faehrt in einer quadratischen Welle von laenge 3
				gear.forward(STRECKE);
				gear.right(DREHEN);
				gear.forward(STRECKE);
				gear.right(DREHEN);
				gear.forward(STRECKE);
				gear.left(DREHEN);
				gear.forward(STRECKE);
				gear.right(DREHEN);
			}
			gear.forward(STRECKE);
		}
	}

	// 3.
	public void arc() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 3; i++) { // faehrt eine art Welle fuehr 3 lambda
				gear.rightArc(0.2, STRECKE * 2); // halbkreis rechts
				gear.leftArc(0.2, STRECKE * 2); // halbkreis links
			}
		}
	}

	// 4.
	public void squares() {
		while (!robot.isEscapeHit()) {
			for (int i = 0; i < 4; i++) {
				gear.forward(STRECKE);
				gear.left(DREHEN);
				gear.forward(STRECKE);
				gear.left(DREHEN);
				gear.forward(STRECKE);
				gear.right(DREHEN);
				gear.forward(STRECKE);
			}
		}
	}

	public static void main(String[] args) {
		new Motoren();
	}

}
