/** 
 *  Drucksensoren
 */ 
package mindstorms;

import ch.aplu.ev3.*;

public class Drucksensoren {
	LegoRobot robot;
	Gear gear;
	TouchSensor ts;
	int drehen = 1500;
    int level = 100;
    public Drucksensoren() {

        // init
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        ts = new TouchSensor();
        robot.addPart(ts);
        lawnmower();

        robot.exit();
    }

    // 1.
    public void lawnmower() {
        us.addTouchListener(new LawnMowerListener(), level);
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }
    
    public class LawnMowerListener implements TouchListener {
        int turns;

        public void released(SensorPort port, int level) {}
        public void pressed(SensorPort port, int level) {
        	gear.backward(500);
            if (turns % 2 == 1) { // stoppt, dreht sich und fährt weiter. Die Richtung ändert sich jede Iteration
				gear.backward(1000);
				gear.right(700);
				gear.forward(1000);
				gear.right(700);
                //gear.rightArc(0.2, 2000);
            } else {
				gear.backward(1000);
				gear.left(700);
				gear.forward(1000);
				gear.left(700);
                //gear.leftArc(0.2, 2000);
            }
            turns++;
        }
    }

    // 2.
    public void maze() {
        String track = "lrrlrrlr"; // hardcoded directions (obviously only works for this maze)
        us.addTouchListener(new MazeTouchListener(), level);
        for (char c : track.toCharArray()) {
            gear.forward(); // move forward until close to a wall
            while (gear.isMoving()) {
                robot.drawString(level + "", 1, 1); // debug
            }
            if (c == 'r') { // rotate left or right depending on char
                gear.right();
            } else {
                gear.left();
            }
        }
    }

    class MazeTouchListener implements TouchListener {
        public void released(SensorPort port, int level) {}
        public void pressed(SensorPort port, int level) {
            gear.stop(); // stoppt, wenn we eine Wand beruehrt
        }
    }

    public static void main(String[] args) {
        new Drucksensoren();
    }
}
