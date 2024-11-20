package mindstorms;
import ch.aplu.ev3.*;

/**
 * Ultraschallsensoren
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

    public void lawnmower() {
        us.addUltrasonicListener(new UltrasonicLawnmowerListener(), level)
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    public void parcours() {
    	us.addUltrasonicListener(new UltrasonicParcoursListener(), level);
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

    class UltrasonicParcoursListener implements UltrasonicListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            //TODO: actual logic 
        }
    }
}
