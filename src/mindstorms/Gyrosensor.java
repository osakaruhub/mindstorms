/**
 * Gyrosensor
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Gyrosensor {
    LegoRobot robot;
    Gear gear;
    GyroAngleSensor angleSensor;
    GyroRateSensor rateSensor;
    final int level = 100;

    // init
    public Gyrosensor() {
        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);
        angleSensor = new GyroAngleSensor(SensorPort.S1);
        robot.addPart(angleSensor);
        square();
        robot.playTone(500, 5000);
        maze();
    }

    // 1.
    public void square() {
    // turns until it has turned 90 degrees, until a square has been traversed
        for (int i = 0; i < 4; i++) {
            gear.forward(2000);
            gear.right();
            while (angleSensor.getValue() != -90) {
            	robot.drawString(angleSensor.getValue() + "", 1,1);
            }
            gear.stop();
        }
    }

    // 2.
    public void maze() {
        // i figured that if it is this particular maze, i should just check when to turn right or left.
        String track = "lrrlrrlr";
        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
        robot.addPart(us);
        us.addUltrasonicListener(new UltrasonicMazeListener(), level);
        
        for (char c : track.toCharArray()) {
            gear.forward();
            while (!robot.isEscapeHit() || gear.isMoving()); // move forward until close to a wall
            if (c == 'r') { // rotate left or right depending on char
                gear.right();
                while (angleSensor.getValue() != -90) {}
            } else {
                gear.left();
                while (angleSensor.getValue() != -90) {}
            }
        }
    }

    class UltrasonicMazeListener implements UltrasonicListener {
        public void near(SensorPort port, int level) { // stops when close to a wall, continues the main Thread
            gear.stop();
        }
        public void far(SensorPort port, int level) {
        	robot.drawString(level + "", 1, 1); //debug
        }
    }

    public static void main(String[] args) {
    	new Gyrosensor();
    }
}
