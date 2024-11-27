package mindstorms;

import ch.aplu.ev3.Gear;
import ch.aplu.ev3.LegoRobot;
import ch.aplu.ev3.UltrasonicSensor;
import ch.aplu.ev3.GyroAngleSensor;
import ch.aplu.ev3.GyroRateSensor;

/**
 * Gyrosensor
 *
 * arguments:
 * 1 -> square()
 * 2 -> maze()
 */

public class Gyrosensor {
    LegoRobot robot;
    Gear gear;
    GyoAngleSensor angleSensor;
    GyroRateSensor rateSensor;

    public Gyrosensor() {
        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);
        angleSensor = new GyroAngleSensor();
        rateSensor = new GyroRateSensor();
    }

    // turns until it has turned 90 degrees
    public void square() {
        for (int i = 0; i < 4; i++) {
            gear.forward(2000);
            gear.right();
            while (angleSensor.getValue() != -90) {}
            gear.stop();
        }
    }

    public void maze() {
        // i figured that if it is this particular maze, i should just check when to turn right or left.
        String track = "lrrlrrlr"
        UltrasonicSensor us = new UltrasonicSensor();
        robot.addPart(us);
        
        for (char c : track.toCharArray()) {
            gear.forward();
            while (gear.isMoving()); // move forward until close to a wall
            if (c == 'r') { // rotate left or right depending on char
                gear.right();
            } else {
                gear.left();
            }
            while (us.getValue().abs() != 90);
            gear.stop();
        }
        //TODO: stud, still dont know whether any maze or this particular maze
    }

    class Ultrasonic implements UltrasonicListener {
        public void near(Sensorport port, int level) {
            gear.stop();
        }
        public void far(Sensorport port, int level) {

        }
    }

    public static void main(String[] args) {
        int arg;
        if (args.length != 0) {
            try {
                arg = args[0].parseInt();
            } catch (NumberFormatException e) {
                System.err.println("not a valid argument: " + args[0]); System.exit(1);
            }
            new Lichtsensoren(arg);
        } else {
            System.err.println("no argument given");
        }
    }
}
