package mindstorms;
import ch.aplu.ev3.*;

/**
 * Ultraschallsensoren
 */
public class Ultraschallsensoren {
    public DruckSensoren() {
        final int drehen = 1500;
        final int trigger = 20;

        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);
        UltraschallSensor us = new UltraschallSensor();
        robot.addPart(us);

        robot.exit();
    }

    public void lawnmower() {
        us.addUltraSchallsensor(new UltrasonicLawnmowerListener(), trigger)
        forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    public void parcours() {
        //TODO: stud
    }

    public class UltrasonicLawnmowerListener() {
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            gear.stop();
            if (turns % 2 == 1) {
                gear.rightArc();
            } else {
                gear.leftArc();
            }
        }
    }

    public class UltrasonicParcourListener {
        public void far(SensorPort port, int level) {
            gear.forward();
        }

        public void near(SensorPort port, int level) {
            //TODO: actual logic 
        }
    }
}
