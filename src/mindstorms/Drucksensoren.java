/** 
 *  Drucksensoren
 */ 
package mindstorms;

import ch.aplu.ev3.*;

public class Drucksensoren {
	private static final int DREHEN = 700; // 90 Grad
    private static final int BACK = 1000;  // 1 sec
	LegoRobot robot;
	Gear gear;
	TouchSensor ts;

    public Drucksensoren() {
        // init
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        ts = new TouchSensor();
        robot.addPart(ts);
        // add method calls here
        robot.exit();
    }

    // 1.
    public void lawnmower() {
        ts.addTouchListener(new LawnMowerListener());
        gear.forward();
        while (!robot.isEscapeHit()) {}
        gear.stop();
    }
    
    public class LawnMowerListener implements TouchListener {
        int turns;

        public void released(SensorPort port) {}
        public void pressed(SensorPort por) {
        	gear.backward(BACK);
            if (turns % 2 == 1) { // stoppt, dreht sich und faehrt weiter. Die Richtung aendert sich jede Iteration
				gear.right(DREHEN);
				gear.forward(BACK);
				gear.right(DREHEN);
                //gear.rightArc(0.2, 2000); // dont mind this. have no clue how thatll work with my 'expertise' of numbers
            } else {
				gear.left(DREHEN);
				gear.forward(BACK);
				gear.left(DREHEN);
                //gear.leftArc(0.2, 2000);
            }
            turns++;
        }
    }

    // 2.
    public void maze() {
        ts.addTouchListener(new MazeTouchListener());
        Tools.startTimer(); // starte den Timer, obwohl die variable time mit Tools.getTime() synchroniesiert wird, wodurch delta time das gesuchte ist (delta zeit = Tools.getTime() - time > 5000)
        gear.forward();
        while (!robot.isEscapeHit());
        Tools.stopTimer();
        gear.stop();
    }

    class MazeTouchListener implements TouchListener {
        private Boolean opt = false;
        private int time = 0;

        public void released(SensorPort port) {
            if (opt && Tools.getTime() - time > 5000) { // geht in die Normaloperation zurueck, wenn 5 Sekunden vergangen sind ohne Anknallen
                opt = false;
            }
        }
        public void pressed(SensorPort port) {  
            gear.backward(1000);
            if (opt) { // beim naechsten male dreht sich der um 180 Grad, und setzt den Timer zurueck
                gear.right(DREHEN * 2); // 180 Grad
            } else { // dreht sich beim ersten mal um 90 Grad nach rechts
                gear.right(DREHEN);
                opt = true;
            }
            gear.forward();
            time = Tools.getTime(); // nach jedem Anknall setzt man den Timer zurueck
        }
    }

    public static void main(String[] args) {
        new Drucksensoren();
    }
}
