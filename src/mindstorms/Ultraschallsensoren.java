package mindstorms;

import ch.aplu.ev3.LegoRobot;
import ch.aplu.ev3.Gear;
import ch.aplu.ev3.UltrasonicSensor;
import ch.aplu.ev3.UltrasonicListener;

/**
 * Ultraschallsensoren
 *
 * arguments:
 * 1 -> lawnmower()
 * 2 -> maze()
 */

public class Ultraschallsensoren {
	LegoRobot robot;
	Gear gear;
	UltrasonicSensor us;
	final int level = 100;
	final int drehen = 1500;

    public Ultraschallsensoren() {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        us = new UltrasonicSensor();
        robot.addPart(us);

        robot.exit();
    }

    // 1.
    public void lawnmower() {
        us.addUltrasonicListener(new UltrasonicLawnmowerListener(), level)
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    // 2.
    public void maze() {
    	us.addUltrasonicListener(new UltrasonicMazeListener(), level);
        //TODO: stud
    }

    class UltrasonicLawnmowerListener implements UltrasonicListener {
    	int turns = 0;
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            gear.stop();
            if (turns % 2 == 1) {
                gear.rightArc(0.2, 2000);
            } else {
                gear.leftArc(0.2, 2000);
            }
            turns++;
        }
    }

    class UltrasonicMazeListener implements UltrasonicListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            //TODO: actual logic 
        }
    }
}
