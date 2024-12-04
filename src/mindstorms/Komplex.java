/**
 * Komplex
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Komplex {
    static int touchCount = 0;
    LegoRobot robot;
    Gear gear;
    LightSensor rul;
    LightSensor lul;
    TouchSensor ts;
    final int drehen = 1250; 
    final int level = 100; //TODO: test

    // init
    public Komplex() {
        robot = new LegoRobot();
        gear = new Gear();
          //create and add 2 LightSensor each with its own Listener
        rul = new LightSensor(SensorPort.S1);
        rul.addLightListener(new RightListener(), level);
        robot.addPart(rul);
        lul = new LightSensor(SensorPort.S2); 
        lul.addLightListener(new LeftListener(), level);
        robot.addPart(lul);
          // create and add TouchSensor
        ts = new TouchSensor(SensorPort.S3);
        ts.addTouchListener(new rotateListener());
        robot.addPart(ts);

        while (!robot.isEscapeHit() || touchCount < 5) {} // continue until 5 rounds have been done
        robot.exit();
    }

    // Zwei LightListener Klassen, je Richtung
    class LeftListener implements LightListener {
        public void dark(SensorPort port, int level) {
        	gear.leftArcMilli(3000);
        }
        public void bright(SensorPort port, int level) {
        	gear.leftArcMilli(2000);
        }
    }
    class RightListener implements LightListener {
        public void dark(SensorPort port, int level) {
        	gear.rightArcMilli(3000);
        }
        public void bright(SensorPort port, int level) {
        	gear.rightArcMilli(2000);
        }
    }

    // dreht sich um, wenn er eine Wand trifft
    class rotateListener implements TouchListener {
        public void pressed(SensorPort port) {
            gear.stop();
            gear.right(drehen);
            gear.forward();
            robot.drawString(touchCount++ + "", 1, 1);
        }
        public void released(SensorPort port) {}
    }
    
    public static void main(String[] args) {
        new Komplex();
    }

}
