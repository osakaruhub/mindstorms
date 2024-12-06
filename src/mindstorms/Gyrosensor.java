/**
 * Gyrosensor
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Gyrosensor {
    private static final int US_LEVEL = 5;      // 5 cm
    private static final int DREHEN = 700;      // 90 Grad
    private static final int BACK = 1000;      // 90 Grad
    LegoRobot robot;
    Gear gear;
    GyroAngleSensor angleSensor;

    // init
    public Gyrosensor() {
        LegoRobot robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        angleSensor = new GyroAngleSensor(SensorPort.S1);
        robot.addPart(angleSensor);
        // add method calls here
    }

    // 1.
    public void square() {
        // turns until it has turned 90 degrees, until a square has been traversed
        for (int i = 0; i < 4; i++) {
            gear.forward(2000);
            gear.right();
            while (angleSensor.getValue() >= -90) {}
            gear.stop();
        }
    }

    // 2.
    public void maze() {
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
        us.addUltrasonicListener(new UltrasonicMazeListener(), US_LEVEL);
        robot.addPart(us);
        Tools.startTimer(); // starte den Timer, obwohl die variable time mit Tools.getTime() synchroniesiert wird, wodurch delta time das gesuchte ist (delta zeit = Tools.getTime() - time > 5000)
        while (!robot.isEscapeHit);
        Tools.stopTimer();
        gear.stop();
    }

    class UltrasonicMazeListener implements UltrasonicListener {
        private Boolean opt = false;
        private int time = 0;

        public void far(SensorPort port, int level) {
            if (opt && Tools.getTime() - time > 5000) { // geht in die Normaloperation zurueck, wenn 5 Sekunden vergangen sind ohne Anknallen
                opt = false;
            }
        }
        public void near(SensorPort port, int level) {  
            gear.backward(BACK);
            gear.right();
            int angle = angleSensor.getValue();
            if (opt) { // beim naechsten male dreht sich der um 180 Grad, und setzt den Timer zurueck
                while(angleSensor.getValue() - angle >= -180) // dreht, bis delta Winkel -180 betraegt.
            } else { // dreht sich beim ersten mal um 90 Grad nach rechts
                while(angleSensor.getValue() - angle >= -90) // dreht, bis delta Winkel -90 betraegt.
                opt = true;
            }
            gear.forward();
            time = Tools.getTime(); // nach jedem Anknall setzt man den Timer zurueck
        }
    }

    public static void main(String[] args) {
        new Gyrosensor();
    }
}
