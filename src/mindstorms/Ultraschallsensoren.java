package mindstorms;
import ch.aplu.ev3.*;

/**
 * Ultraschallsensoren
 */
public class Ultraschallsensoren {
	LegoRobot robot;
	Gear gear;
    public Ultraschallsensoren() {
        final int drehen = 1500;
        final int trigger = 20;

        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        UltraschallSensor us = new UltraschallSensor();
        robot.addPart(us);

        robot.exit();
    }

    public void lawnmower() {
        us.addUltraSchallsensor(new UltrasonicLawnmowerListener(), level)
        forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    public void parcours() {
        //TODO: stud
    }

    public class UltrasonicLawnmowerListener implements UltrasonicListener {
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

    public class UltrasonicParcourListener implements UltrasonicListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            //TODO: actual logic 
        }
    }
}
