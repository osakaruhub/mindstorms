/**
 * Komplex
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Komplex {
    static int touchCount = 0;
    LegoRobot robot;
    Motor leftMotor;
    Motor rightMotor;
    LightSensor rul;
    LightSensor lul;
    final int drehen = 1250; 
    final int level = 100; //TODO: test

    // init
    public Komplex() {
        robot = new LegoRobot();
        // create 2 Motor Instances instead of Gear for handling both motors
        leftMotor = new Motor(MotorPort.A);
        robot.addPart(rightMotor);
        rightMotor = new Motor(MotorPort.B);
        robot.addPart(leftMotor);
        //create and add 2 LightSensor each with its own Listener
        rul = new LightSensor(SensorPort.S1);
        rul.addLightListener(new rightListener(), level);
        robot.addPart(rul);
        lul = new LightSensor(SensorPort.S2); 
        lul.addLightListener(new LeftListener(), level);
        robot.addPart(lul);
        // create and add TouchSensor
        ts = new TouchListener(SensorPort.S3);
        ts.addTouchListener(new rotateListener(), level);
        robot.addPart(ts);

        while (!robot.isEscapeHit() || touchCount < 5) {} // continue until 5 rounds have been done
        robot.exit();
    }

    // two LightListener classes, it will rotate to the acording side, and 
    class rightListener implements LightListener {
        public void dark(SensorPort port, int level) {
            leftMotor.forward();
        }
        public void bright(SensorPort port, int level) {
            leftMotor.stop();
        }
    }
    class LeftListener implements LightListener {
        public void dark(SensorPort port, int level) {
            rightMotor.forward();
        }
        public void bright(SensorPort port, int level) {
            rightMotor.stop();
        }
    }

    // dreht sich um, wenn er eine Wand trifft, und dreht sich um
    class rotateListener implements TouchListener {
        public void pressed(SensorPort port) {
            gear.stop();
            gear.right(drehen);
            gear.forward();
            robot.displayString(touchCount++);
        }
        public void released(SensorPort port) {}
    }
    
    public static void main(String[] args) {
        new Komplex();
    }

}
