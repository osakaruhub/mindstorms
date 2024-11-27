package mindstorms;

import ch.aplu.ev3.LegoRobot;
import ch.aplu.ev3.SensorPort;
import ch.aplu.ev3.Gear;
import ch.aplu.ev3.UltrasonicSensor;
import mindstorms.Gyrosensor.Ultrasonic;
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
	final int drehen = 650;
	static Boolean stop;

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
        String track = "lrrlrrlr";
        us = new UltrasonicSensor(SensorPort.S2);
        robot.addPart(us);
        us.addUltrasonicListener(new Ultrasonic(), level);
        
        for (char c : track.toCharArray()) {
            gear.forward();
            while (gear.isMoving()); // move forward until close to a wall
            if (c == 'r') { // rotate left or right depending on char
                gear.right();
            } else {
                gear.left();
            }
        }
    }

    class UltrasonicLawnmowerListener implements UltrasonicListener {
    	int turns = 0;
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            gear.stop();
            gear.backward(1000);
            if (turns >= 5) {
            	stop = true;
            }
            if (turns % 2 == 1) {
                gear.rightArc(0.2, 2000);
            } else {
                gear.leftArc(0.2, 2000);
            }
            turns++;
        }
    }

    class Ultrasonic implements UltrasonicListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        	robot.drawString(level + "", 1, 1);

        }

        public void near(SensorPort port, int level) {
gear.stop();        }
    }
}
