package mindstorms;

import ch.aplu.ev3.LegoRobot;
import ch.aplu.ev3.Gear;
import ch.aplu.ev3.TouchSensor;
import ch.aplu.ev3.TouchListener;

/** 
 *  
 * arguments:
 * 1 -> lawnmower()
 * 2 -> maze()
 */ 
public class Drucksensoren {
	LegoRobot robot;
	Gear gear;
	TouchSensor ts;
	int drehen = 1500;
    public Drucksensoren() {

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
        while (!robot.isEscapeHit()) {
            gear.forward();
            while (!ts.isPressed()) {}
            gear.stop();
            //TODO: rough estimations, test pls
            gear.backward(200);
            gear.rightArc(0.2, 1000);
        }
    }
    
    public class LawnMowerListener implements TouchListener {
        int turns;

        public void bright(SensorPort port, int level) {}
        public void dark(SensorPort port, int level) {
        	gear.stop();
        	gear.backward(500);
            if (turns % 2 == 1) {
                gear.rightArc(0.2, 2000);
            } else {
                gear.leftArc(0.2, 2000);
            }
            turns++;
        }
    }

    // 2.
    public void maze() {
        gear.forward();
        while (!ts.isPressed()) {}
        gear.stop();
        gear.backward(200);
        gear.right(drehen);
        while (!ts.isPressed()) {
            //TODO: not finished, AI too dumb
        }
    }

  
  public static void main(String[] args)
  {
    new Drucksensoren();
  }
} 
