/**
 * Lichtsensoren
 */ 
package mindstorms;

import ch.aplu.ev3.*;

public class Lichtsensoren {
    private final int drehen = 1250;
    static Boolean stop = false;
    int level = 200;
    LegoRobot robot;
    Gear gear;
    LightSensor ls;

    // init
    public Lichtsensoren() {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        ls = new LightSensor();
        robot.addPart(ls);
        ls.activate(true);
        circle();
        robot.exit();
    }

    // 1.
    public void bw() {
        ls.addLightListener(new bwLightListener(), level); // Im Quellcode wird der Listener gesetzt (this.lL = lL), wodurch der Name setLightListener() logischer ist
        gear.forward();
        while (!robot.isEscapeHit() || stop) {
    	    robot.drawString(ls.getValue() + "", 1, 1); //debug
        }
        gear.stop();
    }

    class bwLightListener implements LightListener {
        private int count;

        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) { // stopt, dreht sich um und fährt weiter, und stopt wenn es 5 mal gemacht hat
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

    // 2.
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
    	    robot.playTone(600, 300); // indiziert ein Streifen
    	    count++;
    	    System.out.println(count); // liest auch die Anzahl an Streifen
            try {
                Thread.sleep(100); // Sleep to prevent busy waiting
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // 3.
    public void circle() {
    	ls.addLightListener(new circleListener(), level);
    	gear.forward();
        while (!robot.isEscapeHit()) {
        	robot.drawString(ls.getValue() +"", 1, 1);
        };
        gear.stop();
    }

    class circleListener implements LightListener{
        public void dark(SensorPort port, int level) { // neigt sich nach links
        	gear.leftArcMilli(2000);
        }
        public void bright(SensorPort port, int level) { // neigt sich stärker nach links, um wieder auf Bahn zu bleiben.
        	gear.leftArcMilli(3000);
        }
    }

    public static void main(String[] args) {
        new Lichtsensoren();
    }
}
