/**
 * Komplex
 *
 * Note that i never tested this, so take this with a grain of salt.
 *
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Komplex {
    private static int stop = false;
    private static final int DREHEN = 1400; // 180 Grad 
    private final int LIGHT_LEVEL = 300; //TODO: test
    LegoRobot robot;
    Gear gear;
    LightSensor ls;
    TouchSensor ts;

    // init
    public Komplex() {
        robot = new LegoRobot();
        gear = new Gear();
          //create and add LightSensor its own Listener
        ls = new LightSensor(SensorPort.S1);
        ls.addLightListener(new LightComplexListener(), LIGHT_LEVEL);
        robot.addPart(ls);
          // create and add TouchSensor
        ts = new TouchSensor(SensorPort.S3);
        ts.addTouchListener(new rotateListener());
        robot.addPart(ts);

        while (!robot.isEscapeHit() || stop) {} // continue until 5 rounds have been done
        robot.exit();
    }

    // Zwei LightListener Klassen, je Richtung
    class LightComplexListener implements LightListener {
        static private Boolean right = false;

        public void dark(SensorPort port, int level) {
            if (right) { // dreht sich in der Richtung des Loops im Bahn
                gear.rightArcMilli(250);
            } else {
                gear.leftArcMilli(250);
            }
        }
        public void bright(SensorPort port, int level) {
            gear.forward();
        }
    }

    // dreht sich um, wenn er eine Wand trifft
    class rotateListener implements TouchListener {
        private int count = 0;

        public void pressed(SensorPort port) {
            gear.stop();
            gear.right(DREHEN + 50); // bisschen mehr, um auf der Bahn zu bleiben, denn der Sensor auf der anderen Seite ist
            gear.forward();
            stop = count++ >= 5; // setzt stop boolean auf true, wenn es 5 mal sich gedreht hat
            right = !right; // schaltet die Richtung des Justieren um
        }
        public void released(SensorPort port) {}
    }
    
    public static void main(String[] args) {
        new Komplex();
    }

}
