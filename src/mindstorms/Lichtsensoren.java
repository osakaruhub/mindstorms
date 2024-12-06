/**
 * Lichtsensoren
 */ 
package mindstorms;

import ch.aplu.ev3.*;

public class Lichtsensoren {
    private static final int DREHEN = 1250; // 180 Grad
    private static final int LEVEL = 300;
    private static Boolean stop = false;    // fuer BWLightListener
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
        // add method calls here
        robot.exit();
    }

    // 1.
    public void bw() {
        ls.addLightListener(new BWLightListener(), LEVEL); // Im Quellcode wird der Listener gesetzt (this.lL = lL), wodurch der Name setLightListener() logischer ist
        gear.forward();
        while (!robot.isEscapeHit() || stop);
        gear.stop();
    }

    class BWLightListener implements LightListener {
        private int count = 0;

        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) { // stoppt, dreht sich um und faehrt weiter, und stopt wenn es 5 mal gemacht hat
                gear.stop();
                gear.left(DREHEN);
                gear.forward();
                count++;
                stop = count >= 5;
        }
    }

    // 2.
    public void countStripes() {
        ls.addLightListener(new CountStripesLightListener(), LEVEL);
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }

    class CountStripesLightListener implements LightListener {
	    int count = 0;
        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) {
    	    robot.playTone(600, 300); // indiziert ein Streifen
    	    System.out.println(count + ""); // liest auch die Anzahl an Streifen
    	    robot.drawString(count++ + "", 1, 1);
            try {
                Thread.sleep(100); // Sleep to prevent busy waiting
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // 3.
    public void circle() {
    	ls.addLightListener(new CircleListener(), LEVEL);
    	gear.forward();
        while (!robot.isEscapeHit());
        gear.stop();
    }

    // Wie in der Vorfuehrung, weiss ich nicht die richtigen Werte
    class CircleListener implements LightListener {
        public void bright(SensorPort port, int level) { // neigt sich nach rechts
        	gear.LeftArcMilli(200);
        }
        public void dark(SensorPort port, int level) { // neigt sich staerker nach rechts, um wieder auf der Bahn zu bleiben.
            gear.forward();
        }
    }

    public static void main(String[] args) {
        new Lichtsensoren();
    }
}
