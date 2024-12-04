/**
 * Ultraschallsensoren
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Ultraschallsensoren {
	LegoRobot robot;
	Gear gear;
	UltrasonicSensor us;
	final int level = 100;
	final int drehen = 650;
	static Boolean stop;

    // init
    public Ultraschallsensoren() {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        us = new UltrasonicSensor();
        robot.addPart(us);
        lawnmower();
        robot.playTone(500, 3000);
        maze();
        robot.exit();
    }

    // 1.
    public void lawnmower() {
        us.addUltrasonicListener(new UltrasonicLawnmowerListener(), level);
        gear.forward();
        while (!robot.isEscapeHit()||stop) {}
        gear.stop();
    }

    // 2.
    public void maze() {
        String track = "lrrlrrlr"; // hardcoded directions (obviously only works for this maze)
        us.addUltrasonicListener(new UltrasonicMazeListener(), level);
        for (char c : track.toCharArray()) {
            gear.forward(); // move forward until close to a wall
            while (gear.isMoving()) {
                robot.drawString(level + "", 1, 1); // debug
            }
            if (c == 'r') { // rotate left or right depending on char
                gear.right();
            } else {
                gear.left();
            }
        }
    }

    class UltrasonicLawnmowerListener implements UltrasonicListener {
    	int turns = 0;
        public void far(SensorPort port, int level) {}
        public void near(SensorPort port, int level) { // stoppt, geht ein bisschen nach hinten, um ein Halbkreis zu machen
            gear.stop();
            gear.backward(1000);
            stop = turns >= 5; // faehrt solange, bis es 5 mal gedreht hat
            if (turns % 2 == 1) { // Die Anzahl der Umdrehungen beeinflusst die Richtung des Halbkreises, startend mit leftArc()
                gear.rightArc(0.2, 2000);
            } else {
                gear.leftArc(0.2, 2000);
            }
            // wont work supposedly
            //turns % 2 == 1 ? gear.rightArc(0.2, 2000) : gear.leftArc(0.2, 2000); // Die Anzahl der Umdrehungen beeinflusst die Richtung des Halbkreises, startend mit leftArc()
            turns++;
        }
    }

    class UltrasonicMazeListener implements UltrasonicListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        }
        public void near(SensorPort port, int level) {
            gear.stop(); // stoppt, wenn es eine Wand naehert, um den Main Thread fortzusetzen
        }
    }
}
