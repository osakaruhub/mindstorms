package mindstorms;

import ch.aplu.ev3.Gear;
import ch.aplu.ev3.LegoRobot;
import ch.aplu.ev3.LightSensor;
import ch.aplu.ev3.LightListener;

/**
 * Lichtsensoren
 * 
 * arguments:
 * 1 -> bw()
 * 2 -> countStripes();
 * 3 -> followLine();
 */ 

public class Lichtsensoren {
    private final int drehen = 1250;
    static Boolean stop = false;
    int level = 100;
    LegoRobot robot;
    Gear gear;
    LightSensor ls;

    public Lichtsensoren(int arg) {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        ls = new LightSensor();
        robot.addPart(ls);
        ls.activate(true);
        switch (arg) {
            case 1:
            bw();
                break;
            case 2:
            countStripes();
                break;
            case 3:
            followLine();
            default:
            System.err.println(" argument: " + arg);
                break;
        }
        robot.exit();
    }

    public void bw() {
        ls.addLightListener(new bwLightListener(), level);
        gear.forward();
        while (!robot.isEscapeHit() || stop) {
    	    robot.drawString(ls.getValue() + "", 1, 1); //debug
        }
        gear.stop();
    }

    class bwLightListener implements LightListener {
        int count;

        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) {
            if (count >= 5) {
                stop = true;
            } else {
                gear.stop();
                gear.left(drehen);
                gear.forward();
                count++;
            }
        }
    }

    public void countStripes() {
        ls.addLightListener(new CountStripesLightListener(), level);
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    class CountStripesLightListener implements LightListener {
	    int count = 0;
        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) {
    	    robot.playTone(600, 300);
    	    count++;
    	    System.out.println(count);
            try {
                Thread.sleep(100); // Sleep to prevent busy waiting
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    //TODO: stub
    public void followLine() {
        //while (!robot.isEscapeHit()) {
        //}
        //
        //}
    }

    //class LeftLightListener implements LightListener{
    //    public void dark(SensorPort port, int level) {}
    //    public void bright(Sensorport, int level) {}
    //}


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
